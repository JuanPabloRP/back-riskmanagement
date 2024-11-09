package com.riskmanagement.back_riskmanagement.controller;

import com.riskmanagement.back_riskmanagement.dto.model.Asset;
import com.riskmanagement.back_riskmanagement.dto.request.AssetRequest;
import com.riskmanagement.back_riskmanagement.dto.response.AssetResponse;
import com.riskmanagement.back_riskmanagement.exception.codes.ExceptionCodesRiskManagementDatabase;
import com.riskmanagement.back_riskmanagement.exception.riskmanagement.AssetException;
import com.riskmanagement.back_riskmanagement.service.interfaces.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = AssetController.ASSET_URI, produces = MediaType.APPLICATION_JSON_VALUE)
@ControllerAdvice
@RequiredArgsConstructor
public class AssetController {
    public static final String ASSET_URI = "/api/v1/assets";

    @Autowired
    AssetService assetService;

    @GetMapping()
    public ResponseEntity<List<AssetResponse>> getAllAssets() {
        try {
            List<AssetResponse> assets = assetService
                    .findAll()
                    .stream()
                    .map(AssetResponse::fromModel)
                    .toList();

            return ResponseEntity.ok(assets);
        } catch (Exception e) {
            throw new AssetException(
                    ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_013, e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetResponse> getAssetById(@PathVariable Integer id) {
        try {
            Asset asset = assetService.findAssetById(id);
            AssetResponse assetResponse = AssetResponse.fromAsset(asset);
            return ResponseEntity.ok(assetResponse);
        } catch (Exception e) {
            throw new AssetException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_017, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<AssetResponse> createAsset(@RequestBody AssetRequest assetRequest) {
        try {
            Asset asset = assetService.create(Asset.fromAssetRequest(assetRequest));
            AssetResponse assetResponse = AssetResponse.fromAsset(asset);
            return ResponseEntity.ok(assetResponse);
        } catch (Exception e) {
            throw new AssetException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_014, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetResponse> updateAsset(@PathVariable Integer id, @RequestBody AssetRequest assetRequest) {
        try {
            Asset asset = assetService.update(id, Asset.fromAssetRequest(assetRequest));
            AssetResponse assetResponse = AssetResponse.fromAsset(asset);
            return ResponseEntity.ok(assetResponse);
        } catch (Exception e) {
            throw new AssetException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_015, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssetResponse> deleteAsset(@PathVariable Integer id) {
        try {
            Asset asset = assetService.delete(id);
            AssetResponse assetResponse = AssetResponse.fromAsset(asset);
            return ResponseEntity.ok(assetResponse);
        } catch (Exception e) {
            throw new AssetException(ExceptionCodesRiskManagementDatabase.DB_RISK_MANAGEMENT_016, e.getMessage());
        }
    }
}