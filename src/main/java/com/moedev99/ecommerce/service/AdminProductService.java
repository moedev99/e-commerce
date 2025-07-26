package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import org.springframework.web.multipart.MultipartFile;

public interface AdminProductService {
    public void createProduct(ProductReq productReq, MultipartFile image);
}
