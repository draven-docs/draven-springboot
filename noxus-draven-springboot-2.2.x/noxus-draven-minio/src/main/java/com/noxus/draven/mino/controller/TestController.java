package com.noxus.draven.mino.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.noxus.draven.common.minio.service.MinioTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: testController
 * @package: com.noxus.draven.mino.controller
 * @author: draven
 * @date: 2020/7/18 15:28
 */
@RestController
@RequestMapping
public class TestController {

    private final MinioTemplate minioTemplate;

    public TestController(MinioTemplate minioTemplate) {
        this.minioTemplate = minioTemplate;
    }

    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) {
        String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());
        Map<String, String> resultMap = new HashMap<>(4);
        resultMap.put("bucketName", "minioadmin");
        resultMap.put("fileName", fileName);

        try {
            minioTemplate.putObject("minioadmin", fileName, file.getInputStream());
            //文件管理数据记录,收集管理追踪文件
            //fileLog(file, fileName);
        } catch (Exception e) {
            //log.error("上传失败", e);
            //return R.failed(e.getLocalizedMessage());
        }
        return "";
    }

    /**
     * 读取文件
     *
     * @param fileName
     * @param response
     */
    @PostMapping("getFile")
    public InputStream getFile(String fileName, HttpServletResponse response) {
        int separator = fileName.lastIndexOf(StrUtil.DASHED);
        InputStream inputStreams = null;
        try (InputStream inputStream = minioTemplate.getObject(fileName.substring(0, separator),
                fileName.substring(separator + 1))) {
            response.setContentType("application/octet-stream; charset=UTF-8");
            long copy = IoUtil.copy(inputStream, response.getOutputStream());
            inputStreams = inputStream;

        } catch (Exception e) {
            //log.error("文件读取异常", e);
        }
        System.out.println("haaha");
        System.out.println("haaha");
        System.out.println("haaha");
        System.out.println("haaha");
        return inputStreams;
    }
}
