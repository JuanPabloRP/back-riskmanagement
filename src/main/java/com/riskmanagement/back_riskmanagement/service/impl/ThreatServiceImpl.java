package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.Threat;
import com.riskmanagement.back_riskmanagement.entity.ThreatEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.ThreatException;
import com.riskmanagement.back_riskmanagement.repository.ThreatRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.ThreatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThreatServiceImpl implements ThreatService {

    private final ThreatRepository threatRepository;

    @Override
    public List<Threat> findAll() {
        if (threatRepository.findAll().isEmpty()) {
            return List.of();
        }

        return threatRepository
                .findAll()
                .stream()
                .map(Threat::fromEntity)
                .toList();
    }

    @Override
    public Threat findThreatById(Integer id) {
        return threatRepository.findById(id)
                .map(Threat::fromEntity)
                .orElse(null);
    }

    @Override
    public Threat create(Threat threat) {
        ThreatEntity threatEntity = threatRepository.save(Threat.toEntity(threat));
        return Threat.fromEntity(threatEntity);
    }

    @Override
    public Threat update(Integer id, Threat threat) {
        ThreatEntity threatEntity = threatRepository.findById(id).orElse(null);
        if (threatEntity != null) {
            threatEntity.setUserId(threat.getUserId());
            threatEntity.setName(threat.getName());
            threatEntity.setDescription(threat.getDescription());
            threatEntity.setType(threat.getType());
            threatEntity.setActive(threat.isActive());
            threatEntity.setCreationDate(LocalDate.parse(threat.getCreationDate()));
            threatEntity.setModificationDate(LocalDate.parse(threat.getModificationDate()));
            threatRepository.save(threatEntity);
        }
        return threatEntity != null ? Threat.fromEntity(threatEntity) : null;
    }

    @Override
    public Threat delete(Integer id) {
        try {
            ThreatEntity threatEntity = threatRepository.findById(id).orElse(null);
            if (threatEntity == null) {
                return null;
            }
            threatRepository.deleteById(id);
            return Threat.fromEntity(threatEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ThreatException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_016, e.getMessage());
        }
    }
}