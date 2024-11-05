package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;

public interface AuthService {
    User signup(UserRequest userRequest);

}
