package com.moedev99.ecommerce.controller;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.service.AdminProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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
}
