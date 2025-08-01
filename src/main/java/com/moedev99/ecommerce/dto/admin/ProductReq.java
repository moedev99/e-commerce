package com.moedev99.ecommerce.dto.admin;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductReq(
                        @NotBlank(message = "Category can not be Blank") String category,
                         @NotBlank(message = "Name can not be Blank") String name,
                         @NotNull(message = "Price can not be null") @Positive( message = "Price should be a positive number") double price,
                         @Min(0) double discount,
                         @Min(0) int quantityInStock) {
}
