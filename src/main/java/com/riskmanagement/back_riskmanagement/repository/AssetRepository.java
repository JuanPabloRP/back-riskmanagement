package com.riskmanagement.back_riskmanagement.repository;

import com.riskmanagement.back_riskmanagement.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Integer> {

}