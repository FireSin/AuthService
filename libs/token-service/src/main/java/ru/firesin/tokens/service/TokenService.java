package ru.firesin.tokens.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.firesin.tokens.dto.TokenDTO;

public class TokenService {

    private final Algorithm algorithm;

    public TokenService(@Value("masterKey") String masterKey) {
        algorithm = Algorithm.HMAC512(masterKey);
    }

    public String generateToken(TokenDTO tokenDTO) { //TODO сделай рефлексию, сейчас изменяя поле ты должен будешь его добавить везде, хочу чтобы не было такого)
//        JWTClaimsBuilder jwtClaimsBuilder = new JWTClaimsBuilder()
//
//        Field[] fields = tokenDTO.getClass().getFields();
//        for (var field:fields) {
//
//        }
        return JWT.create().withClaim("Role", tokenDTO.getRole()).sign(algorithm);
    }

    public TokenDTO deserializationToken(String token) throws JWTVerificationException{
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        var role = decodedJWT.getClaim("Role").asString();
        return new TokenDTO(role);
    }
}
