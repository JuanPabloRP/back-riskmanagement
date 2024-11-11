package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;

public interface AuthService {
    UserResponse signup(UserRequest userRequest);

}
