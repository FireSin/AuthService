package ru.firesin.feature.password.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.firesin.feature.password.api.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

    private static final int WORKLOAD = 12;

    public String hashPassword(String passwordPlaintext) {
        return BCrypt.hashpw(passwordPlaintext, BCrypt.gensalt(WORKLOAD));
    }

    public boolean checkPassword(String passwordPlaintext, String storedHash) {
        return BCrypt.checkpw(passwordPlaintext, storedHash);
    }
}
