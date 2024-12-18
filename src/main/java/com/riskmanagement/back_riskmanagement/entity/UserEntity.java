package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "user_information")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(unique = true)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "identification")
    private String identification;

    @Column(name = "birthDate")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private RoleEntity roleId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusEntity statusId;

}
