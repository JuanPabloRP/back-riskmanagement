package com.riskmanagement.back_riskmanagement.dto.request;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRequest {
    private String name;


    public static UserEntity toEntity(UserRequest userRequest){
        return UserEntity
                .builder()
                .name(userRequest.name)
                .build();
    }

    public static UserResponse toResponse(UserEntity userEntity){
        return UserResponse
                .builder()
                .id(userEntity.getUserId().toString())
                .name(userEntity.getName())
                .build();
    }

    public static UserRequest fromUser(User user){
        return UserRequest
                .builder()
                .name(user.getName())
                .build();
    }
}
