package com.riskmanagement.back_riskmanagement.service.impl;

import com.riskmanagement.back_riskmanagement.dto.model.Asset;
import com.riskmanagement.back_riskmanagement.entity.AssetEntity;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.AssetException;
import com.riskmanagement.back_riskmanagement.repository.AssetRepository;
import com.riskmanagement.back_riskmanagement.service.interfaces.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Override
    public List<Asset> findAll() {
        if (assetRepository.findAll().isEmpty()) {
            return List.of();
        }

        return assetRepository
                .findAll()
                .stream()
                .map(Asset::fromEntity)
                .toList();
    }

    @Override
    public Asset findAssetById(Integer id) {
        return assetRepository.findById(id)
                .map(Asset::fromEntity)
                .orElse(null);
    }

    @Override
    public Asset create(Asset asset) {
        AssetEntity assetEntity = assetRepository.save(Asset.toEntity(asset));
        return Asset.fromEntity(assetEntity);
    }

    @Override
    public Asset update(Integer id, Asset asset) {
        AssetEntity assetEntity = assetRepository.findById(id).orElse(null);
        if (assetEntity != null) {
            assetEntity.setAssetName(asset.getAssetName());
            assetRepository.save(assetEntity);
        }
        return assetEntity != null ? Asset.fromEntity(assetEntity) : null;
    }

    @Override
    public Asset delete(Integer id) {
        try {
            AssetEntity assetEntity = assetRepository.findById(id).orElse(null);
            if (assetEntity == null) {
                return null;
            }
            assetRepository.deleteById(id);
            return Asset.fromEntity(assetEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AssetException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_016, e.getMessage());
        }
    }
}