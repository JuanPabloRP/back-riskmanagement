package com.riskmanagement.back_riskmanagement.dto.response;

import org.hibernate.sql.ast.tree.cte.CteContainer;

import com.riskmanagement.back_riskmanagement.dto.model.Control;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControlResponse {
    private Integer id;
    private String userId;
    private String name;
    private String type;
    private String description;
    private Integer statusId;
    private String statusName;

}