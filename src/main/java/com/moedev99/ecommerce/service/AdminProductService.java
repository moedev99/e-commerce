package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.dto.admin.UpdateProductReq;
import com.moedev99.ecommerce.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface AdminProductService {
    void createProduct(ProductReq productReq, MultipartFile image);
    Product updateProduct(UpdateProductReq updateProductReq, MultipartFile image);

}
