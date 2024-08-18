package com.smartjob.servicio.users.domain.dto.request;

import lombok.Getter;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Getter
public class LoginRequestDto {
    private String email;
    private String password;
}
