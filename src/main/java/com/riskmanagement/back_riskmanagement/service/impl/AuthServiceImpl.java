package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.repository.RoleRepository;
import com.riskmanagement.back_riskmanagement.repository.StatusRepository;
import com.riskmanagement.back_riskmanagement.repository.UserRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.AuthService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public UserResponse signup(UserRequest userRequest) {

        User userToCreate = User.toModel(userRequest);

        RoleEntity role = roleRepository.findById(userToCreate.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role no encontrado"));
        StatusEntity status = statusRepository.findById(userToCreate.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

        UserEntity userEntity =  User.toEntity(userToCreate, role, status);

        UserEntity savedEntity = userRepository.save(userEntity);

        User userCreated = User.toModel(savedEntity);

        return User.toResponse(userCreated, role.getRoleName(), status.getStatusName());
    }
}
