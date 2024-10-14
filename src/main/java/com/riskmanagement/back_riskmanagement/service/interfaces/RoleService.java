package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.Role;
import com.riskmanagement.back_riskmanagement.dto.model.User;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findRoleById(Integer id);
    Role create(Role role);
    Role update(Integer id,Role role);
    Role delete(Integer id);
}
