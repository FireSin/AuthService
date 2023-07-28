package ru.firesin.feature.password.api;

public interface PasswordService {

    String hashPassword(String passwordPlaintext);

    boolean checkPassword(String passwordPlaintext, String storedHash);
}
