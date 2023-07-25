package ru.firesin.auth.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String msg){
        super(msg);
    }
}
