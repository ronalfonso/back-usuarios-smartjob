package com.smartjob.servicio.users.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth", schema = "auths")
@PrimaryKeyJoinColumn(name="id")
public class Auth extends User {

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = true)
    private String token;

    @Column(name = "is_active", nullable = true)
    private Boolean isActive;

    @Column(name = "last_login", nullable = true)
    private LocalDate lastLogin;
}
