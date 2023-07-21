package ru.firesin.auth.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    private final static int workload = 12;

    public static String hashPassword(String passwordPlaintext) {
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(passwordPlaintext, salt);
    }

    public static boolean checkPassword(String passwordPlaintext, String stored_hash) {
        return BCrypt.checkpw(passwordPlaintext, stored_hash);
    }
}
