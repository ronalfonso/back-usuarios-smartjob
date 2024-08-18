package com.smartjob.servicio.users.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey;

    public String generateToken(String user) {
        return Jwts.builder()
                .setSubject(user)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
