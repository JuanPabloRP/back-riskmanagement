package com.riskmanagement.back_riskmanagement.dto.model;

import com.riskmanagement.back_riskmanagement.dto.request.RoleRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RoleResponse;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {
    private String id;
    private String name;


    // De RoleRequest a Role
    public static Role toModel(RoleRequest request) {
        return Role.builder()
                .name(request.getName())
                .build();
    }

    // De RoleEntity a Role
    public static Role toModel(RoleEntity entity) {
        return Role.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .build();
    }

    // De Role a RoleEntity
    public static RoleEntity toEntity(Role model) {
        return RoleEntity.builder()
                .name(model.getName())
                .build();
    }

    // De Role a RoleResponse
    public static RoleResponse toResponse(Role model) {
        return RoleResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
