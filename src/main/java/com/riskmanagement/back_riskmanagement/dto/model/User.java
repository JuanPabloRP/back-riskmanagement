package com.riskmanagement.back_riskmanagement.dto.model;


import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String identification;
    private Date birthDate;
    private Integer roleId;
    private Integer statusId;

    public static User fromEntity(UserEntity userEntity){
        return User
                .builder()
                .id(userEntity.getUserId().toString())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .roleId(userEntity.getRoleId())
                .birthDate(userEntity.getBirthDate())
                .identification(userEntity.getIdentification())
                .statusId(userEntity.getStatusId())
                .build();
    }

    public static UserEntity toEntity(User user){
        return UserEntity
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .birthDate(user.getBirthDate())
                .identification(user.getIdentification())
                .password(user.getPassword())
                .statusId(user.getStatusId())
                .build();
    }

    public static User fromUserRequest(UserRequest userRequest){
        return User
                .builder()
                .name(userRequest.getFirstName()+userRequest.getLastName())
                .email(userRequest.getEmail())
                .roleId(userRequest.getRoleId())
                .birthDate(userRequest.getBirthDate())
                .identification(userRequest.getIdentification())
                .password(userRequest.getPassword())
                .statusId(userRequest.getStatusId())
                .build();

    }


}
