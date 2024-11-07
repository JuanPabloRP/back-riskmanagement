package com.riskmanagement.back_riskmanagement.dto.response;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
        private Integer id;
        private String name;
        private String email;
        private String identification;
        private Date birthDate;
        private Integer roleId;
        private String roleName;
        private Integer statusId;
        private String statusName;
}
