package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.user.UserReqDto;
import com.moedev99.ecommerce.exception.EmailExistsException;

public interface UserService {
    void createUser(UserReqDto userDto);
    UserReqDto getUser(Long id);
}
