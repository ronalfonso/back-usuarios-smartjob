package com.smartjob.servicio.users.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Getter
@Builder
public class UserRegisterResponseDto {
    private UUID id;
    private LocalDate created;
    private LocalDateTime modified;
    private LocalDate lastLogin;
    private String token;
    private Boolean isActive;
}
