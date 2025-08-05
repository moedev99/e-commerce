package com.moedev99.ecommerce.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserReqDto(
        @NotBlank(message = "User  Name cannot be blank") String username,
        @NotBlank(message = "Email cannot be blank") @Email String email,
        @NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Must be at least 6 characters") String password
) {
}
