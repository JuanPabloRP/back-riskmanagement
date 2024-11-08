package com.riskmanagement.back_riskmanagement.repository;

import com.riskmanagement.back_riskmanagement.entity.RiskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRepository extends JpaRepository<RiskEntity, Integer> {

}
