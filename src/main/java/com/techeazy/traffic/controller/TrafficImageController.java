package com.techeazy.traffic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/traffic/image")
public class TrafficImageController {

    private static final String IMAGE_DIR = "/tmp/trafficimage";

    public TrafficImageController() {
        File directory = new File(IMAGE_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam(value = "file", required = false) MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded.");
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File destination = new File(IMAGE_DIR + File.separator + System.currentTimeMillis() + "_" + fileName);

        try {
            file.transferTo(destination);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the image.");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<String> getImageCount() {
        File folder = new File(IMAGE_DIR);
        File[] files = folder.listFiles();
        int count = (files != null) ? files.length : 0;

        return ResponseEntity.ok("Total count of image images : " + count);
    }
}
