package com.riskmanagement.back_riskmanagement.config.security;

import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class JWTAuthtenticationConfig {

    @Autowired
    JwtUtils jwtUtils;

    public String getJWTToken(UserResponse userResponse) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(userResponse.getName());

        String token = Jwts
                .builder()
                .setId("espinozajgeJWT")
                .setSubject(userResponse.getName())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .claim("userInformation", userResponse)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constans.TOKEN_EXPIRATION_TIME))
                .signWith(jwtUtils.getSigningKey(),  SignatureAlgorithm.HS512).compact();

        return "Bearer " + token;
    }
}