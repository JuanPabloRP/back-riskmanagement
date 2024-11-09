package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.Threat;

import java.util.List;

public interface ThreatService {
    List<Threat> findAll();
    Threat findThreatById(Integer id);
    Threat create(Threat threat);
    Threat update(Integer id, Threat threat);
    Threat delete(Integer id);
}