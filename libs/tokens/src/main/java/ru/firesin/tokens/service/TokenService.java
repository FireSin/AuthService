package ru.firesin.tokens.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {
    private final String masterKey;

    public String generateToken(String role){
        Algorithm algorithm = Algorithm.HMAC512(masterKey);
        try {
            String token = JWT.create() //TODO inline
                .withClaim("Role", role)
                .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){ //TODO Смысл?
            throw exception;
        }
    }

    public boolean checkToken(String token, String access){ //TODO Вместо boolean лучше ошибки кидать
        if (token == null){
            return false;
        }
        Algorithm algorithm = Algorithm.HMAC512(masterKey); //TODO Вынести в поле
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            var role = decodedJWT.getClaim("Role").asString();
            if (!role.equals(access)) {
                return false;
            }
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
