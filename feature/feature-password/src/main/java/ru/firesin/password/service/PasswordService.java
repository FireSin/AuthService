package ru.firesin.password.service;

import org.springframework.stereotype.Service;

@Service
public interface PasswordService {

    String hashPassword(String passwordPlaintext);

    boolean checkPassword(String passwordPlaintext, String storedHash);
}
