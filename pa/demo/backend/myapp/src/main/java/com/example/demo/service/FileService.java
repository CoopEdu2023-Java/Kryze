package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private static final String UPLOAD_DIR = "uploads/";

    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No file selected for uploading");
        }

        try {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdir();
            }

            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "File upload failed", e);
        }
    }
}
