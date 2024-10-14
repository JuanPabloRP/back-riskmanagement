package com.riskmanagement.back_riskmanagement.dto.response;

import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
        private String id;
        private String name;


        public static UserResponse fromModel(User user){
                return UserResponse
                        .builder()
                        .id(user.getId())
                        .name(user.getName())
                        .build();
        }

        public static UserResponse fromUser(User user){
                return UserResponse
                        .builder()
                        .name(user.getName())
                        .build();
        }

}
