package com.riskmanagement.back_riskmanagement.dto.model;

import com.riskmanagement.back_riskmanagement.dto.request.AssetRequest;
import com.riskmanagement.back_riskmanagement.entity.AssetEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Asset {
    private String assetId;
    private String assetName;

    public static Asset fromEntity(AssetEntity assetEntity) {
        return Asset
                .builder()
                .assetId(assetEntity.getAssetId().toString())
                .assetName(assetEntity.getAssetName())
                .build();
    }

    public static AssetEntity toEntity(Asset asset) {
        return AssetEntity
                .builder()
                .assetName(asset.getAssetName())
                .build();
    }

    public static Asset fromAssetRequest(AssetRequest assetRequest) {
        return Asset
                .builder()
                .assetName(assetRequest.getAssetName())
                .build();
    }
}