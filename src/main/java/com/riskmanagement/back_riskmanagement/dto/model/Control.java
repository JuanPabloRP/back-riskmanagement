package com.riskmanagement.back_riskmanagement.dto.model;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.request.ControlRequest;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import com.riskmanagement.back_riskmanagement.entity.RoleEntity;
import com.riskmanagement.back_riskmanagement.entity.StatusEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import com.riskmanagement.back_riskmanagement.entity.ControlEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Control {
    private Integer id;
    private String name;
    private Integer userId;
    private String type;
    private String description;
    private Integer statusId;
    private Integer userNameId;
    private String userName;
    private String statusName;


    public static Control toModel(ControlRequest request) {
        return Control.builder()
                .name(request.getName())
                .userId(request.getUserId())
                .type(request.getType())
                .description(request.getDescription())
                .statusId(request.getStatusId())
                .build();
    }

    // De ControlEntity a Control
    public static Control toModel(ControlEntity entity) {
        return Control.builder()
                .id(entity.getId())
                .name(entity.getName())
                .userId(entity.getUserId().getUserId())
                .type(entity.getType())
                .description(entity.getDescription())
                .statusId(entity.getStatusId().getStatusId())
                .build();
    }

    // De Control a ControlEntity
    public static ControlEntity toEntity(Control model,UserEntity user, StatusEntity status) {
        return ControlEntity.builder()
                .name(model.getName())
                .userId(user)
                .description(model.getDescription())
                .type(model.getType())
                .statusId(status)
                .build();
    }

    // De Control a ControlResponse
    public static ControlResponse toResponse(Control model, String userName, String statusName) {
        return ControlResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .userId(model.getUserId())
                .userName(userName)
                .description(model.getDescription())
                .type(model.getType())
                .statusId(model.getStatusId())
                .statusName(statusName)
                .build();
    }

}