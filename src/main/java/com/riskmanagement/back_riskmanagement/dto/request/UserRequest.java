package com.riskmanagement.back_riskmanagement.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String identification;
    private Date birthDate;
    private Integer roleId;
    private Integer statusId;
}
