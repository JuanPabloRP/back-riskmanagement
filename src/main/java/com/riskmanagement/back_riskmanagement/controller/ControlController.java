package com.riskmanagement.back_riskmanagement.controller;


import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.service.interfaces.ControlService;

//import com.riskmanagement.back_riskmanagement.exception.riskmanagement.ControlException;
//import com.riskmanagement.back_riskmanagement.service.interfaces.ControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;
import java.util.List;

import javax.sound.sampled.CompoundControl;

@RestController
@RequestMapping(value = ControlController.CONTROL_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
public class ControlController {
    public static final String CONTROL_URI = "/api/v1/controls"; 
    
    @Autowired
    ControlService controlService;

    //cambiar los codigos de las excepciones 

    @GetMapping() 
    public ResponseEntity<List<ControlResponse>> getAllControls() {
       return ResponseEntity.ok(controlService.findAll()); 
    }

    

}
