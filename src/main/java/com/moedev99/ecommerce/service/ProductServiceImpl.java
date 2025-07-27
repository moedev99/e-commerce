package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.admin.ProductRes;
import com.moedev99.ecommerce.entity.Product;
import com.moedev99.ecommerce.mapper.ProductMapper;
import com.moedev99.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductRes> getAllProduct() {
        List<Product> products = productRepository.findAll();

        return productMapper.mapToProductRes(products);

    }
}
