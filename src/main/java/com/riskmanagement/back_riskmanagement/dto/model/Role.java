package com.riskmanagement.back_riskmanagement.dto.model;

import com.riskmanagement.back_riskmanagement.dto.request.RoleRequest;
import com.riskmanagement.back_riskmanagement.dto.request.UserRequest;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Role {
    private String roleId;
    private String roleName;

    public static Role fromEntity(RoleEntity roleEntity){
        return Role
                .builder()
                .roleId(roleEntity.getRoleId().toString())
                .roleName(roleEntity.getRoleName())
                .build();
    }

    public static RoleEntity toEntity(Role role){
        return RoleEntity
                .builder()
                .roleName(role.getRoleName())
                .build();
    }

    public static Role fromRoleRequest(RoleRequest roleRequest){
        return Role
                .builder()
                .roleName(roleRequest.getRoleName())
                .build();
    }
}
