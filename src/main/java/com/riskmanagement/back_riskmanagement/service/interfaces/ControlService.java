package com.riskmanagement.back_riskmanagement.service.interfaces;

import java.util.List;

import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;

public interface ControlService {
    List<ControlResponse> findAll();
    ControlResponse findControlById(Integer id);
    ControlResponse create(ControlRequest controlRequest);
    ControlResponse update(Integer id,ControlRequest controlRequest);
    ControlResponse delete(Integer id);
}

