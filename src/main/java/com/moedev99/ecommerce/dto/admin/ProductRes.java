package com.moedev99.ecommerce.dto.admin;

public record ProductRes(Long id, String category, String name, String url, double price, double discount, int quantityInStock) {
}
