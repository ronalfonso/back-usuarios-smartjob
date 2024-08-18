package com.smartjob.servicio.users.domain.dto.request;

import lombok.Getter;

import java.util.List;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Getter
public class UserRequestDto {
    private String name;
    private String email;
    private List<PhoneRequestDto> phones;
    private String password;
}
