package com.riskmanagement.back_riskmanagement.service.interfaces;

import com.riskmanagement.back_riskmanagement.dto.model.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> findAll();
    Asset findAssetById(Integer id);
    Asset create(Asset asset);
    Asset update(Integer id, Asset asset);
    Asset delete(Integer id);
}