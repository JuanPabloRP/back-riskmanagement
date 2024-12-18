package com.riskmanagement.back_riskmanagement.repository;

import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {
}
