package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.entity.Product;
import com.moedev99.ecommerce.exception.FileValidityException;
import com.moedev99.ecommerce.mapper.ProductMapper;
import com.moedev99.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@Slf4j
public class AdminProductServiceImpl implements AdminProductService{
    private final S3Service s3Service;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public void createProduct(ProductReq productReq, MultipartFile image) {
        checkImage(image);
        String imageUrl = s3Service.uploadImage(image);
        Product product = productMapper.mapToProduct(productReq, imageUrl);
        Product saveP = productRepository.save(product);

        log.info("Product id {} saved in the DB successfully", saveP.getId());
    }

    private void checkImage(MultipartFile image){
        if (image.isEmpty()) {
            throw new FileValidityException("File is empty");
        }

        if (image.getSize() > 5 * 1024 * 1024) { // 5MB limit
            throw new FileValidityException("File too large");
        }
        // Check file type
        String contentType = image.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new FileValidityException("File must be an image");
        }
    }
}
