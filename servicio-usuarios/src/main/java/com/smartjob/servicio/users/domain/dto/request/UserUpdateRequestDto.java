package com.smartjob.servicio.users.domain.dto.request;

import lombok.Getter;

import java.util.List;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Getter
public class UserUpdateRequestDto {
    private String name;
    private boolean isActive;
    private List<PhoneRequestDto> phones;
}
