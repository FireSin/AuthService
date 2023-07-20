package ru.firesin.auth.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    private final static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return hashed_password;
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        return BCrypt.checkpw(password_plaintext, stored_hash);
    }
}
