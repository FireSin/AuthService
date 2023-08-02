package ru.firesin.user.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String msg){
        super(msg);
    }
}
