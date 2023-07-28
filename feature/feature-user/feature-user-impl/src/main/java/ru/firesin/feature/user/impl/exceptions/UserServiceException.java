package ru.firesin.feature.user.impl.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String msg){
        super(msg);
    }
}
