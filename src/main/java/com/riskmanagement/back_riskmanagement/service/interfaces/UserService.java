package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Integer id);
    User create(User user);
    User update(Integer id,User user);
    User delete(Integer id);
}
