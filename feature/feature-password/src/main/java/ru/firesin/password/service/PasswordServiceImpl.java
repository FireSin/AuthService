package ru.firesin.password.service;

import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private static final int WORKLOAD = 12;

    public String hashPassword(String passwordPlaintext) {
        return BCrypt.hashpw(passwordPlaintext, BCrypt.gensalt(WORKLOAD));
    }

    public boolean checkPassword(String passwordPlaintext, String storedHash) {
        return BCrypt.checkpw(passwordPlaintext, storedHash);
    }
}
