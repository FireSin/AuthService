package ru.firesin.auth.exceptions;

public class UsernamePasswordException extends RuntimeException {
    public UsernamePasswordException(String message) {
        super(message);
    }
}
