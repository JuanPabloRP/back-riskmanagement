package com.riskmanagement.back_riskmanagement.dto.request;


import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
//import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ControlRequest{
    private Integer id;
    private Integer userId;
    private String name;
    private String type;
    private String description;
    private Integer statusId;

}