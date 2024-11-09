package com.riskmanagement.back_riskmanagement.repository;

import com.riskmanagement.back_riskmanagement.entity.ThreatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreatRepository extends JpaRepository<ThreatEntity, Integer> {
}