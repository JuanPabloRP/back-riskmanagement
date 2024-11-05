package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public UserResponse signup (@RequestBody UserRequest userRequest){
        return UserResponse.fromUser(authService.signup(userRequest));
    }
}
