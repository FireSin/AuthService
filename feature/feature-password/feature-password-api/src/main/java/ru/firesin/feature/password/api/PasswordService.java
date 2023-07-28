package ru.firesin.feature.password.api;

import org.springframework.stereotype.Service;

@Service
public interface PasswordService {

    String hashPassword(String passwordPlaintext);

    boolean checkPassword(String passwordPlaintext, String storedHash);
}
