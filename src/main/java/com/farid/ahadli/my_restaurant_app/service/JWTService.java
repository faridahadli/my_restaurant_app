package com.farid.ahadli.my_restaurant_app.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class JWTService {
    byte[]  SecretKey;


    public JWTService(@Value("${restaurant.key}") String base64Key) {

        SecretKey =  Base64.getDecoder().decode(base64Key);

    }

    public String generateToken(Map<String, Object> additionalClaims, String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 1000*60*5 ))
                .addClaims(additionalClaims)
                .signWith(SignatureAlgorithm.HS256, SecretKey)
                .compact();


    }

    public <T>  T getClaim(String token, Function<Claims, T> claimsFunction) {
        Claims claims = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token).getBody();
        return claimsFunction.apply(claims);
    }

    public boolean validateToken(String token, String username) {
        return getClaim(token, Claims::getSubject).equals(username) && !ifTokenExpired(token);
    }

    private boolean ifTokenExpired(String token) {
        Date exp = getClaim(token, Claims::getExpiration);
        return exp != null && new Date().after(exp);
    }

}
