package com.riskmanagement.back_riskmanagement.controller;


import com.riskmanagement.back_riskmanagement.dto.model.Role;
import com.riskmanagement.back_riskmanagement.dto.request.RoleRequest;
import com.riskmanagement.back_riskmanagement.dto.response.RoleResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.RoleException;
import com.riskmanagement.back_riskmanagement.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RoleController.ROLE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
public class RoleController {
    public static final String ROLE_URI = "/api/v1/roles";

    @Autowired
    RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        try {
            List<RoleResponse> roles = roleService
                    .findAll()
                    .stream()
                    .map(RoleResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(roles);
        }catch (Exception e){
            throw new RoleException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Integer id){
        try{
            Role role = roleService.findRoleById(id);
            RoleResponse roleResponse = RoleResponse.fromRole(role);
            return ResponseEntity.ok(roleResponse);
        }catch (Exception e){
            throw new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_017, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest roleRequest){
        try{
            Role role = roleService.create(Role.fromRoleRequest(roleRequest));
            RoleResponse roleResponse = RoleResponse.fromRole(role);
            return ResponseEntity.ok(roleResponse);
        }catch (Exception e){
            throw new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_014, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable Integer id, @RequestBody RoleRequest roleRequest){
        try{
            Role role = roleService.update(id, Role.fromRoleRequest(roleRequest));
            RoleResponse roleResponse = RoleResponse.fromRole(role);
            return ResponseEntity.ok(roleResponse);
        }catch (Exception e){
            throw new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_015, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleResponse> deleteRole(@PathVariable Integer id){
        try{
            Role role = roleService.delete(id);
            return ResponseEntity.ok(RoleResponse.fromRole(role));
        }catch (Exception e){
            throw new RoleException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_016, e.getMessage());
        }
    }
}
