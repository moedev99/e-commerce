package com.moedev99.ecommerce.mapper;

import com.moedev99.ecommerce.dto.admin.ProductReq;
import com.moedev99.ecommerce.dto.admin.ProductRes;
import com.moedev99.ecommerce.entity.Product;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductReq req, String url){
        return new Product(req.category(),req.name(), url, req.price(), req.discount(), req.quantityInStock());
    }
    public List<ProductRes>  mapToProductRes(List<Product> products){
        List<ProductRes> productResList = new ArrayList<>();

        for (Product product : products){
            productResList.add(new ProductRes(product.getId(),product.getCategory(), product.getName(), product.getUrl(), product.getPrice(), product.getDiscount(), product.getQuantityInStock()));
        }
        return productResList;
    }
}
