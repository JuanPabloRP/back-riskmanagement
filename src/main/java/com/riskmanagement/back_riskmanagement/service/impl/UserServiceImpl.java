package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.UserException;
import com.riskmanagement.back_riskmanagement.repository.RoleRepository;
import com.riskmanagement.back_riskmanagement.repository.StatusRepository;
import com.riskmanagement.back_riskmanagement.repository.UserRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(userEntity -> {
                    RoleEntity role = roleRepository.findById(userEntity.getRoleId().getId())
                            .orElseThrow(() -> new EntityNotFoundException("Role no encontrado"));
                    StatusEntity status = statusRepository.findById(userEntity.getStatusId().getStatusId())
                            .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));
                    User user = User.toModel(userEntity);
                    return User.toResponse(user, role.getName(), status.getStatusName());
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_008, "Usuario no encontrado"));

        RoleEntity role = roleRepository.findById(userEntity.getRoleId().getId())
                .orElseThrow(() -> new EntityNotFoundException("Role no encontrado"));
        StatusEntity status = statusRepository.findById(userEntity.getStatusId().getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

        User user = User.toModel(userEntity);
        return User.toResponse(user, role.getName(), status.getStatusName());
    }

    @Override
    public UserResponse update(Integer id, UserRequest userRequest) {
        UserEntity existingUserEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_009, "Usuario no encontrado"));

        RoleEntity role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role no encontrado"));
        StatusEntity status = statusRepository.findById(userRequest.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status no encontrado"));

        User user1 = User.toModel(userRequest);
        UserEntity updatedEntity = User.toEntity(user1, role,status);


        // Guardar la nueva instancia en el repositorio
        updatedEntity = userRepository.save(updatedEntity);

        User userUpdated = User.toModel(updatedEntity);
        return User.toResponse(userUpdated, role.getName(), status.getStatusName());
    }


    @Override
    public UserResponse delete(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_010, "Usuario no encontrado"));

        userRepository.delete(userEntity);

        RoleEntity role = userEntity.getRoleId();
        StatusEntity status = userEntity.getStatusId();
        User userDeleted = User.toModel(userEntity);
        return User.toResponse(userDeleted, role.getName(), status.getStatusName());
    }
}
