package com.riskmanagement.back_riskmanagement.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", unique = true)
    @Setter
    private String roleName;


}
