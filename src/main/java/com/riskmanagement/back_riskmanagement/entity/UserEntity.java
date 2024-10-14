package com.riskmanagement.back_riskmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_information")
@Getter
@Builder
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(unique = true)
    private String name;

    @Column(name = "password")
    private String password;



    /*@Column(name = "identification")
    @NotBlank(message = "Ingrese la identificación")
    private String identification;*/
}
