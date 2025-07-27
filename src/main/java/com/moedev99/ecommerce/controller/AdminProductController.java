package com.moedev99.ecommerce.controller;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.dto.admin.UpdateProductReq;
import com.moedev99.ecommerce.entity.Product;
import com.moedev99.ecommerce.exception.ResourceNotFoundException;
import com.moedev99.ecommerce.service.AdminProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminProductController {
    private final AdminProductService adminProductService;
    @PostMapping(value = "/create-product", consumes = {"multipart/form-data"})
    public ResponseEntity<String> createProduct(@Valid @RequestPart("product") ProductReq product, @RequestPart("image") MultipartFile image){

        adminProductService.createProduct(product, image);

        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-product", consumes = {"multipart/form-data"})
    public ResponseEntity<Product> updateProduct(@Valid @RequestPart(value = "product", required = false) UpdateProductReq req, @RequestPart(value = "image", required = false) MultipartFile image ){
        if (req == null){
            throw new ResourceNotFoundException("Product object is required!");
        }
        return new ResponseEntity<>(adminProductService.updateProduct(req, image), HttpStatus.OK);
    }
}
