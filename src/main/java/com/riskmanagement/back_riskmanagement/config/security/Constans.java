package com.riskmanagement.back_riskmanagement.config.security;

public class Constans {
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer";
    public static final String SUPER_SECRET_KEY = "";
    public static  final String AUTH_URL = "/api/v1/auth";
    public static final long TOKEN_EXPIRATION_TIME = 86_400_000; // 10 days
}
