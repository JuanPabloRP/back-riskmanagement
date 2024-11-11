package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.Risk;
import com.riskmanagement.back_riskmanagement.dto.response.RiskResponse;
import com.riskmanagement.back_riskmanagement.entity.RiskEntity;
import com.riskmanagement.back_riskmanagement.repository.RiskRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.RiskService;
import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService {

    @Autowired
    private RiskRepository riskRepository;

    @Override
    public List<RiskResponse> getAllRisks() {
        List<RiskEntity> risks = riskRepository.findAll();
        return risks.stream()
                .map(RiskResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Risk findRiskById(Integer id) {
        RiskEntity riskEntity = riskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Risk no encontrado"));
        return Risk.fromEntity(riskEntity);
    }

    @Override
    public Risk createRisk(Risk risk) {
        RiskEntity riskEntity = Risk.toEntity(risk);
        RiskEntity savedEntity = riskRepository.save(riskEntity);
        return Risk.fromEntity(savedEntity);
    }

    @Override
    public Risk updateRisk(Integer id, Risk risk) {
        RiskEntity riskEntity = riskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Risk no encontrado"));
        riskEntity.setRiskName(risk.getRiskName());
        RiskEntity updatedEntity = riskRepository.save(riskEntity);
        return Risk.fromEntity(updatedEntity);
    }

    @Override
    public void deleteRisk(Integer id) {
        if (!riskRepository.existsById(id)) {
            throw new EntityNotFoundException("Risk no encontrado");
        }
        riskRepository.deleteById(id);
    }
}

