package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.dto.user.UserReqDto;
import com.moedev99.ecommerce.entity.User;
import com.moedev99.ecommerce.exception.EmailExistsException;
import com.moedev99.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void createUser(UserReqDto userDto) {
        User byEmail = userRepository.findByEmail(userDto.email());
        if (byEmail != null){
            throw new EmailExistsException("This email is in use");
        }
        userRepository.save(new User(userDto.username(), userDto.email(), bCryptPasswordEncoder.encode(userDto.password())));
    }

    @Override
    public UserReqDto getUser(Long id) {
        return null;
    }
}
