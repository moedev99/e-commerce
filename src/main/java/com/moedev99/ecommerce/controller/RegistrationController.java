package com.moedev99.ecommerce.controller;

import com.moedev99.ecommerce.dto.user.UserReqDto;
import com.moedev99.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/register")
@AllArgsConstructor
@Slf4j
public class RegistrationController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody  UserReqDto user){
        userService.createUser(user);
        return new  ResponseEntity<String>("User Created", HttpStatus.CREATED);
    }
}
