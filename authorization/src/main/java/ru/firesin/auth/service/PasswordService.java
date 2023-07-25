package ru.firesin.auth.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    private static final int workload = 12;

    public static String hashPassword(String passwordPlaintext) {
        return BCrypt.hashpw(passwordPlaintext, BCrypt.gensalt(workload));
    }

    public static boolean checkPassword(String passwordPlaintext, String stored_hash) {
        return BCrypt.checkpw(passwordPlaintext, stored_hash);
    }
}
