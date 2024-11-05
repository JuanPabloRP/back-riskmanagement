package com.riskmanagement.back_riskmanagement.dto.request;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
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
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String identification;
    private Date birthDate;
    private Integer roleId;
    private Integer statusId;


    public static UserEntity toEntity(UserRequest userRequest){
        return UserEntity
                .builder()
                .name(userRequest.getFirstName()+userRequest.getLastName())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .roleId(userRequest.getRoleId())
                .identification(userRequest.getIdentification())
                .birthDate(userRequest.getBirthDate())
                .statusId(userRequest.getStatusId())
                .build();
    }



}
