package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();
    UserResponse findUserById(Integer id);
    UserResponse update(Integer id, UserRequest userRequest);
    UserResponse delete(Integer id);
}
