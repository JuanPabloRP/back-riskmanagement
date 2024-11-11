package com.riskmanagement.back_riskmanagement.service.impl;


import com.riskmanagement.back_riskmanagement.dto.model.Role;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.RoleRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RoleResponse;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.RoleException;
import com.riskmanagement.back_riskmanagement.repository.RoleRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleResponse> findAll() {
        List<Role> roles = roleRepository.findAll().stream().map(Role::toModel).toList();
        return roles.stream().map(Role::toResponse).toList();
    }

    @Override
    public RoleResponse findRoleById(Integer id) {
        Role role = roleRepository
                .findById(id)
                .map(Role::toModel)
                .orElseThrow(() ->
                        new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_017, null)
                );

        return Role.toResponse(role);
    }

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        Role role = Role.toModel(roleRequest);
        Role roleCreated = Role.toModel(roleRepository.save(Role.toEntity(role)));
        return Role.toResponse(roleCreated);
    }

    @Override
    public RoleResponse update(Integer id, RoleRequest roleRequest) {
        RoleEntity roleEntity = roleRepository.findById(id)
                .orElseThrow(() -> new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_017, null));

        if (roleRequest.getName() != null) {
            roleEntity.setName(roleRequest.getName());
        }

        roleRepository.save(roleEntity);

        return Role.toResponse(Role.toModel(roleEntity));
    }

    @Override
    public RoleResponse delete(Integer id) {
        Role role = roleRepository
                .findById(id)
                .map(Role::toModel)
                .orElseThrow(() ->
                        new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_017, null)
                );
        roleRepository.deleteById(id);
        return Role.toResponse(role);
    }
}
