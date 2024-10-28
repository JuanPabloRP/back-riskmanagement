package com.riskmanagement.back_riskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = AuthController.AUTH_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    public static final String AUTH_URI = "/api/v1/auth";


}
