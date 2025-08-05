package com.moedev99.ecommerce.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moedev99.ecommerce.dto.user.LoginUserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try{
            LoginUserDto loginUserDto = new ObjectMapper().readValue(request.getInputStream(), LoginUserDto.class);


            LoginUserDto user = new LoginUserDto(loginUserDto.email(), loginUserDto.password());

            log.info("this login user: {}", user);
            return super.attemptAuthentication(request, response);
        }catch(IOException e){
            throw new RuntimeException("Unknown Error");
        }
    }


}
