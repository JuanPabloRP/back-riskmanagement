package com.riskmanagement.back_riskmanagement.dto.response;

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
    private String controlId;
    private String controlName;
     /*
    private String controlType;
    private String controlStatus;
    private String controlDescription;
    private String controlActive;

     */

}