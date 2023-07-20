package ru.firesin.auth.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordService { //TODO Нахуй это делать бином, если всё - статика?
    private final static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if(null == stored_hash || !stored_hash.startsWith("$2a$")) //TODO Че происходит?
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison"); //TODO Странный код стайл + зачем полный путь?

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return(password_verified);
    }
}
