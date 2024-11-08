package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.Risk;
import com.riskmanagement.back_riskmanagement.dto.model.Role;
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
    public List<Role> findAll() {
        if (roleRepository.findAll().isEmpty()) {
            return List.of();
        }

        return roleRepository
                .findAll()
                .stream()
                .map(Role::fromEntity)
                .toList();
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id)
                .map(Role::fromEntity)
                .orElse(null);
    }

    @Override
    public Role create(Role role) {
        RoleEntity roleEntity = roleRepository.save(Role.toEntity(role));
        return Role.fromEntity(roleEntity);
    }

    @Override
    public Role update(Integer id, Role role) {
        RoleEntity roleEntity = roleRepository.findById(id).orElse(null);
        if(roleEntity != null){
            roleEntity.setRoleName(role.getRoleName());
            roleRepository.save(roleEntity);
        }
        return roleEntity != null ?  Role.fromEntity(roleEntity) : null;
    }

    @Override
    public Role delete(Integer id) {
        try{
            RoleEntity roleEntity = roleRepository.findById(id).orElse(null);
            if(roleEntity == null){
                return null;
            }
            roleRepository.deleteById(id);
            return Role.fromEntity(roleEntity);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_016, e.getMessage());
        }
    }
}
