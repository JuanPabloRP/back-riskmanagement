package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.repository.RoleRepository;
import com.riskmanagement.back_riskmanagement.repository.StatusRepository;
import com.riskmanagement.back_riskmanagement.repository.UserRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public User signup(UserRequest userRequest) {
        User user = User.fromUserRequest(userRequest);

        return User.fromEntity(userRepository.save(User.toEntity(user)));
    }
}
