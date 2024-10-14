package com.riskmanagement.back_riskmanagement.dto.request;


import com.riskmanagement.back_riskmanagement.dto.model.Role;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.response.RoleResponse;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
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
public class RoleRequest {
    private Integer roleId;
    private String roleName;


    public static RoleEntity toEntity(RoleRequest roleRequest){
        return RoleEntity
                .builder()
                .roleId(roleRequest.roleId)
                .roleName(roleRequest.roleName)
                .build();
    }

    public static RoleResponse toResponse(RoleEntity roleEntity){
        return RoleResponse
                .builder()
                .roleId(roleEntity.getRoleId().toString())
                .roleName(roleEntity.getRoleName())
                .build();
    }

    public static RoleRequest fromRole(Role role){
        return RoleRequest
                .builder()
                .roleId(Integer.parseInt(role.getRoleId()))
                .roleName(role.getRoleName())
                .build();
    }
}
