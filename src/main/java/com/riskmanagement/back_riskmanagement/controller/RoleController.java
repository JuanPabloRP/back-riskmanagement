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
    public static final String ROLE_URI = "/api/v1/role";

    @Autowired
    RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Integer id){
            return ResponseEntity.ok(roleService.findRoleById(id));
    }

    @PostMapping()
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest roleRequest){
        return ResponseEntity.ok(roleService.create(roleRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable Integer id, @RequestBody RoleRequest roleRequest){
        return ResponseEntity.ok(roleService.update(id, roleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleResponse> deleteRole(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.delete(id));
    }
}
