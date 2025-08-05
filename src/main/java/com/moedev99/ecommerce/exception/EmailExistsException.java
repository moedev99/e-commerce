package com.moedev99.ecommerce.exception;

public class EmailExistsException extends RuntimeException{

    public EmailExistsException(String message){
        super(message);
    }
}
