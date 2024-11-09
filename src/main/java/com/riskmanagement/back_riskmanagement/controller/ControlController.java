package com.riskmanagement.back_riskmanagement.controller;


import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.service.interfaces.ControlService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = ControlController.CONTROL_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControlController {
    public static final String CONTROL_URI = "/api/v1/control";

    @Autowired
    ControlService controlService;


    @GetMapping()
    public ResponseEntity<List<ControlResponse>> getAllControls() {
        return ResponseEntity.ok(controlService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ControlResponse> getControlById(@PathVariable Integer id) {

        return ResponseEntity.ok(controlService.findControlById(id));
    }

    @PostMapping()
    public ResponseEntity<ControlResponse> createControl(@RequestBody ControlRequest controlRequest) {
        return ResponseEntity.ok(controlService.create(controlRequest));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ControlResponse> updateControl(@PathVariable Integer id, @RequestBody ControlRequest controlRequest) {
        return ResponseEntity.ok(controlService.update(id, controlRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ControlResponse> deleteControl(@PathVariable Integer id) {
        return ResponseEntity.ok(controlService.delete(id));
    }
}

