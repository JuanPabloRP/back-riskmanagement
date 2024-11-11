package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.Role;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.RoleRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAll();
    RoleResponse findRoleById(Integer id);
    RoleResponse create(RoleRequest roleRequest);
    RoleResponse update(Integer id,RoleRequest roleRequest);
    RoleResponse delete(Integer id);
}
