package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.dto.model.User;
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
    /*
    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        try{
            List<UserResponse> users = userService
                    .findAll()
                    .stream()
                    .map(UserResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(users);
        }catch (Exception e){
            throw new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_007, e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        try {
            UserResponse user = UserResponse.fromModel(userService.findUserById(id));
            return ResponseEntity.ok(user);
        }catch (UserException e){
            throw new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_011, e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        try{
            User user = userService.update(id, User.fromUserRequest(userRequest));
            UserResponse userResponse = UserResponse.fromUser(user);
            return ResponseEntity.ok(userResponse);
        }catch (UserException e){
            throw new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_009, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id){
        try{
            User user = userService.delete(id);
            UserResponse userResponse = UserResponse.fromUser(user);
            return ResponseEntity.ok(userResponse);
        }catch (UserException e){
            throw new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_010, e.getMessage());
        }
    }
    */
}
