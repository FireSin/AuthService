package ru.firesin.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String msg){
        super(msg);
    }
}
