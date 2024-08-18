package com.smartjob.servicio.users.utils;

import com.smartjob.servicio.users.application.UserService;
import com.smartjob.servicio.users.domain.entity.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Service
@RequiredArgsConstructor
public class JwtUtil {

    private final UserService userService;

    @Value("${jwt.secret-key}")
    private String secretKey;


    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            // se puede obtener el usuario aqui con sus roles y hacer otras validaciones (por ejemplo, roles de usuario):
            // List<String> roles = claims.get("roles", List.class);

            String userId = claims.getSubject();
            Auth user = userService.findAuthById(userId);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
