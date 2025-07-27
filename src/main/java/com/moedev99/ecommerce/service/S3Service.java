package com.moedev99.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadImage(MultipartFile image);
    String updateImage(MultipartFile image, String url);
}
