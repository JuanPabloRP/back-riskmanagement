package com.riskmanagement.back_riskmanagement.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    // Clave secreta (asegúrate de cambiarla y mantenerla segura en producción)
    private static final String SECRET_KEY = Base64.getEncoder().encodeToString("your-256-bit-secret".getBytes());

    public Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public Claims getClaims(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }
}
