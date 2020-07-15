package com.noxus.draven.fast.controller;

import com.github.tobato.fastdfs.domain.FileInfo;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.noxus.draven.fast.config.FastDFSUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
public class FastController {
    @Resource
    private FastDFSUtil fastDFSUtil;

    @Value("${fdfs.web-server-url}")
    private String fastdfsUrl;

    @Value("${fdfs.http.secret_key}")
    private String fastdfsToken;

    /**
     * The field key exceeds its maximum permitted size of 1048576 bytes
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public String upload(@RequestBody MultipartFile file) throws IOException {
        String filePath = fastDFSUtil.uploadFile(file);
        return filePath;
    }

    @RequestMapping(value = "/downloads", method = {RequestMethod.GET})
    public void downloads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String fileUrl = request.getParameter("fileUrl");

        byte[] data = fastDFSUtil.download(fileUrl);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.jpg", "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.jpg", "UTF-8"));

        // 写出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(data, outputStream);
    }

    /**
     * 生成访问链接
     *
     * @param response
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/location", method = {RequestMethod.GET})
    public String location(HttpServletResponse response, HttpServletRequest request, Model model) {
        String fileUrl = request.getParameter("location");
        System.out.println(fileUrl);
        //token
        String token = fastdfsToken;
        String IP = fastdfsUrl;
        fileUrl = FastDFSUtil.getToken(fileUrl, token, IP);
        model.addAttribute("Url", fileUrl);
        return "" + fileUrl;
    }


}
