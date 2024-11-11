package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.UserException;
import com.riskmanagement.back_riskmanagement.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = UserController.USER_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    public static final String USER_URI = "/api/v1/user";

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {

            return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {

            return ResponseEntity.ok(userService.findUserById(id));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
            return ResponseEntity.ok(userService.update(id, userRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id) {

            return ResponseEntity.ok(userService.delete(id));

    }
}
