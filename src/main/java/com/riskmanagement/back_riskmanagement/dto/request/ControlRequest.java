package com.riskmanagement.back_riskmanagement.dto.request;


import com.riskmanagement.back_riskmanagement.dto.model.Control;
import com.riskmanagement.back_riskmanagement.dto.model.User;
import com.riskmanagement.back_riskmanagement.dto.response.ControlResponse;
import com.riskmanagement.back_riskmanagement.dto.response.UserResponse;
import com.riskmanagement.back_riskmanagement.entity.ControlEntity;
import com.riskmanagement.back_riskmanagement.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ControlRequest{
    private String controlId;
    private String controlName;
    
    /*
    private String controlType;
    private String controlStatus;
    private String controlDescription;
    private String controlActive;

     */
    


}