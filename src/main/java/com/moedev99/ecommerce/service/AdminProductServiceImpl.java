package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@Slf4j
public class AdminProductServiceImpl implements AdminProductService{
    private final S3Service s3Service;
    @Override
    public void createProduct(ProductReq productReq, MultipartFile image) {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        if (image.getSize() > 5 * 1024 * 1024) { // 5MB limit
            throw new IllegalArgumentException("File too large");
        }
        // Check file type
        String contentType = image.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("File must be an image");
        }

       try {
           String imageUrl = s3Service.uploadImage(image);
           log.info(imageUrl);
       }catch (Exception e){
           log.info("error happened {}", e.getMessage());

       }
    }
}
