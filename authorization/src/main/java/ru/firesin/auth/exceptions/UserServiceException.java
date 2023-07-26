package ru.firesin.auth.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String msg){
        super(msg);
    }
}
