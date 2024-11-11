package com.riskmanagement.back_riskmanagement.service.interfaces;
import com.riskmanagement.back_riskmanagement.dto.model.TreatmentPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreatmentPlanService {
    List<TreatmentPlan> findAll();
    TreatmentPlan findById(Integer id);
    TreatmentPlan create(TreatmentPlan treatmentPlan);
    TreatmentPlan update(Integer id, TreatmentPlan treatmentPlan);
    TreatmentPlan delete(Integer id);
}
