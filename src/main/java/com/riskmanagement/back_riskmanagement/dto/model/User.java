package com.riskmanagement.back_riskmanagement.dto.model;


import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String identification;
    private Date birthDate;
    private Integer roleId;
    private Integer statusId;

    // De UserRequest a User
    public static User toModel(UserRequest request) {
        return User.builder()
                .name(request.getFirstName()+request.getLastName())
                .password(request.getPassword())
                .email(request.getEmail())
                .identification(request.getIdentification())
                .birthDate(request.getBirthDate())
                .roleId(request.getRoleId())
                .statusId(request.getStatusId())
                .build();
    }

    // De UserEntity a User
    public static User toModel(UserEntity entity) {
        return User.builder()
                .id(entity.getUserId())
                .name(entity.getName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .identification(entity.getIdentification())
                .birthDate(entity.getBirthDate())
                .roleId(entity.getRoleId().getRoleId())
                .statusId(entity.getStatusId().getStatusId())
                .build();
    }

    // De User a UserEntity
    public static UserEntity toEntity(User model, RoleEntity role, StatusEntity status) {
        return UserEntity.builder()
                .name(model.getName())
                .password(model.getPassword())
                .email(model.getEmail())
                .identification(model.getIdentification())
                .birthDate(model.getBirthDate())
                .roleId(role)
                .statusId(status)
                .build();
    }

    // De User a UserResponse
    public static UserResponse toResponse(User model, String roleName, String statusName) {
        return UserResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .identification(model.getIdentification())
                .birthDate(model.getBirthDate())
                .roleId(model.getRoleId())
                .roleName(roleName)
                .statusId(model.getStatusId())
                .statusName(statusName)
                .build();
    }
}
