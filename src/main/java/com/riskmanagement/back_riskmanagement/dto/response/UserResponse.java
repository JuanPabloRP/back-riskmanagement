package com.riskmanagement.back_riskmanagement.dto.response;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
        private String id;
        private String name;
        private String email;
        private String identification;
        private Date birthDate;
        private Integer roleId;
        private Integer statusId;


        public static UserResponse fromModel(User user){
                return UserResponse
                        .builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .birthDate(user.getBirthDate())
                        .identification(user.getIdentification())
                        .roleId(user.getRoleId())
                        .statusId(user.getStatusId())
                        .id(user.getId())
                        .build();
        }

        public static UserResponse fromUser(User user){
                return UserResponse
                        .builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .birthDate(user.getBirthDate())
                        .identification(user.getIdentification())
                        .roleId(user.getRoleId())
                        .statusId(user.getStatusId())
                        .id(user.getId())
                        .build();
        }

        public static UserResponse toResponse(UserEntity userEntity){
                return UserResponse
                        .builder()
                        .name(userEntity.getName())
                        .email(userEntity.getEmail())
                        .birthDate(userEntity.getBirthDate())
                        .identification(userEntity.getIdentification())
                        .roleId(userEntity.getRoleId())
                        .statusId(userEntity.getStatusId())
                        .id(String.valueOf(userEntity.getUserId()))
                        .build();
        }
}
