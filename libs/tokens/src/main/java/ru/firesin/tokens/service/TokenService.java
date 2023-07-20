package ru.firesin.tokens.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final String masterKey;
    private final Algorithm algorithm;

    public TokenService(@Value("masterKey") String masterKey) {
        this.masterKey = masterKey;
        algorithm = Algorithm.HMAC512(masterKey);
    }

    public String generateToken(String role){
        String token = JWT.create().withClaim("Role", role).sign(algorithm);
        return token;
    }

    public void checkToken(String token, String access) throws JWTVerificationException{
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        var role = decodedJWT.getClaim("Role").asString();
        if (!role.equals(access)) {
            throw new JWTVerificationException("Access denied");
        }
    }
}
