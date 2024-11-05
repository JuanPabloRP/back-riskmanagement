package com.riskmanagement.back_riskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riskmanagement.back_riskmanagement.service.interfaces.AuthService;

@RestController
@RequestMapping(value = AuthController.AUTH_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    public static final String AUTH_URI = "/api/v1/auth";

    @Autowired
    AuthService authService;

    @PostMapping(value = "/signup")
    public String signup (){
        return"HOLA";
    }
}
