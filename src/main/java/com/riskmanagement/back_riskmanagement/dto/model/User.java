package com.riskmanagement.back_riskmanagement.dto.model;


import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String id;
    private String name;

    public static User fromEntity(UserEntity userEntity){
        return User
                .builder()
                .id(userEntity.getUserId().toString())
                .name(userEntity.getName())
                .build();
    }

    public static UserEntity toEntity(User user){
        return UserEntity
                .builder()
                .name(user.getName())
                .build();
    }

    public static User fromUserRequest(UserRequest userRequest){
        return User
                .builder()
                .name(userRequest.getName())
                .build();
    }


}
