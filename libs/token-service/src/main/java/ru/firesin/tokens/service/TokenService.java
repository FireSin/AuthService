package ru.firesin.tokens.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.firesin.tokens.dto.TokenDTO;

import java.lang.reflect.Field;

public class TokenService {

    private final Algorithm algorithm;

    public TokenService(@Value("masterKey") String masterKey) {
        algorithm = Algorithm.HMAC512(masterKey);
    }

    public String generateToken(TokenDTO tokenDTO) {
        JWTCreator.Builder jwtBuilder = JWT.create();

        Field[] fields = tokenDTO.getClass().getDeclaredFields();
        for (var field:fields) {
            try{
                field.setAccessible(true);
                jwtBuilder = jwtBuilder.withClaim(field.getName(), (String)field.get(tokenDTO));
                field.setAccessible(false);
            } catch (Exception e){
                throw new RuntimeException("Can't read field TokenDTO in generate token");
            }
        }
        return jwtBuilder.sign(algorithm);
    }

    public TokenDTO deserializationToken(String token) throws JWTVerificationException {
        TokenDTO tokenDTO = new TokenDTO();
        Field[] fields = tokenDTO.getClass().getDeclaredFields();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        for (var field:fields){
            var value = decodedJWT.getClaim(field.getName()).asString();
            try {
                field.setAccessible(true);
                field.set(tokenDTO, value);
                field.setAccessible(false);
            } catch (Exception e) {
                throw new RuntimeException("Can't read or set field TokenDTO in deserialization token");
            }
        }
        return tokenDTO;
    }
}
