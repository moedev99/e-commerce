package com.moedev99.ecommerce.mapper;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.entity.Product;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductReq req, String url){
        return new Product(req.category(),req.name(), url, req.price(), req.discount(), req.quantityInStock());
    }
}
