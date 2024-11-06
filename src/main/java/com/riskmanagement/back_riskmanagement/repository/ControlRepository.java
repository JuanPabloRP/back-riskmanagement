package com.riskmanagement.back_riskmanagement.repository;

import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<ControlEntity, Integer> {
}
