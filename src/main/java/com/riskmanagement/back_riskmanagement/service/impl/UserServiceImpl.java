package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.UserException;
import com.riskmanagement.back_riskmanagement.repository.UserRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(Integer id, User user) {
        return null;
    }

    @Override
    public User delete(Integer id) {
        return null;
    }

    /*
    @Override
    public List<User> findAll() {
        if (userRepository.findAll().isEmpty()) {
            return List.of();
        }
        return userRepository
                .findAll()
                .stream()
                .map(User::fromEntity)
                .toList();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository
                .findById(id)
                .map(User::fromEntity)
                .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_011, ""));
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = userRepository.save(User.toEntity(user));
        return User.fromEntity(userEntity);
    }

    @Override
    public User update(Integer id, User user) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_012, ""));

        return User.fromEntity(userEntity);
    }

    @Override
    public User delete(Integer id) {
        try{
            userRepository.deleteById(id);
            return null;
        }catch (Exception e){
            throw new UserException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_010, e.getMessage());
        }


    }
    */

}
