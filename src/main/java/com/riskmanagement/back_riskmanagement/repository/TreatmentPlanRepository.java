package com.riskmanagement.back_riskmanagement.repository;
import com.riskmanagement.back_riskmanagement.dto.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Integer> {
}
