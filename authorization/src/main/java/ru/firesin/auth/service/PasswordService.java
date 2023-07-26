package ru.firesin.auth.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    private static final int WORKLOAD = 12;

    public static String hashPassword(String passwordPlaintext) {
        return BCrypt.hashpw(passwordPlaintext, BCrypt.gensalt(WORKLOAD));
    }

    public static boolean checkPassword(String passwordPlaintext, String storedHash) {
        return BCrypt.checkpw(passwordPlaintext, storedHash);
    }
}
