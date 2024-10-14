package com.riskmanagement.back_riskmanagement.dto.response;

import com.riskmanagement.back_riskmanagement.dto.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {
    private String roleId;
    private String roleName;


    public static RoleResponse fromModel(Role role){
        return RoleResponse
                .builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }

    public static RoleResponse fromRole(Role role){
        return RoleResponse
                .builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }
}
