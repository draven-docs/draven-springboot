package com.noxus.draven.fast.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import org.csource.fastdfs.ProtoCommon;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

@Configuration
@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDFSUtil {

    private final Logger logger = LoggerFactory.getLogger(FastDFSUtil.class);

    @Value(value = "${fdfs.nginx-host}")
    private String nginxHost;

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;


    @Value("${fdfs.web-server-url}")
    private String fastdfsUrl;


    @Value("${fdfs.http.secret_key}")
    private String fastdfsToken;


    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(File file) throws IOException {
        StorePath storePath = storageClient.uploadFile(new FileInputStream(file), file.length(),
                FilenameUtils.getExtension(file.getName()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return getResAccessUrl(storePath);
    }

    // 封装图片完整URL地址
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = storePath.getFullPath();
        return nginxHost + '/' + fileUrl;
    }

    /**
     * 传图片并同时生成一个缩略图 "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadImageAndCrtThumbImage(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }


    /**
     * @param fileUrl
     * @return
     */
    public FileInfo queryFileInfo(String fileUrl) {
        StorePath storePath = StorePath.praseFromUrl(fileUrl);
        FileInfo fileInfo = storageClient.queryFileInfo(storePath.getGroup(), storePath.getPath());
        return fileInfo;
    }

    /**
     * 下载文件
     *
     * @param fileUrl 文件url
     * @return
     */
    public byte[] download(String fileUrl) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        byte[] bytes = storageClient.downloadFile(group, path, new DownloadByteArray());
        return bytes;
    }


    // 封装图片完整URL地址
    private String getResAccessUrls(StorePath storePath) {
        String fileUrl = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
        return fileUrl;
    }


    public static String getToken(String fid, String secret_key, String IP) {

        String substring = fid.substring(fid.indexOf("/") + 1);
        //unix时间戳 以秒为单位
        int ts = (int) (System.currentTimeMillis() / 1000);
        String token = new String();
        try {
            token = ProtoCommon.getToken(substring, ts, secret_key);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IP);
        sb.append(fid);
        sb.append("?token=").append(token);
        sb.append("&ts=").append(ts);
        //System.out.println(sb.toString());

        return sb.toString();
    }


}