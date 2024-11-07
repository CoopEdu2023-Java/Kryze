package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileController {

    // 设置文件存储的目录路径
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // 检查是否有文件上传
        if (file.isEmpty()) {
            return new ResponseEntity<>("No file selected for uploading", HttpStatus.BAD_REQUEST);
        }

        try {
            // 创建文件存储目录（如果不存在）
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // 获取文件的存储路径
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

            // 将文件写入到目标路径
            Files.write(filePath, file.getBytes());

            return new ResponseEntity<>("File uploaded successfully: " + file.getOriginalFilename(), HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
