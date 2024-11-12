package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.config.security.JWTAuthtenticationConfig;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riskmanagement.back_riskmanagement.service.interfaces.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = AuthController.AUTH_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    public static final String AUTH_URI = "/api/v1/auth";

    @Autowired
    AuthService authService;

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping(value = "/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = authService.signup(userRequest);
        String token = jwtAuthtenticationConfig.getJWTToken(userResponse);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userResponse);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<UserResponse> signin (@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.signup(userRequest));
    }

    @PostMapping(value = "/generate-token")
    public ResponseEntity<UserResponse> generateToken (@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.signup(userRequest));
    }

    @PostMapping(value = "/signout")
    public ResponseEntity<UserResponse> signout (@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.signup(userRequest));
    }

    @PostMapping(value = "/forgot-password")
    public ResponseEntity<UserResponse> forgotPassword (@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.signup(userRequest));
    }
}
