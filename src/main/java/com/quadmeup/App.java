package com.quadmeup;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
            String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

            Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                    SignatureAlgorithm.HS256.getJcaName());

            Instant now = Instant.now();
            String jwtToken = Jwts.builder()
                    .claim("name", "Aqdas")
                    .claim("email", "aqdase@example.com")
                    .setSubject("Aqdas JWT Demo")
                    .setId(UUID.randomUUID().toString())
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plusSeconds(50)))
                    .signWith(hmacKey)
                    .compact();
            System.out.println( jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}