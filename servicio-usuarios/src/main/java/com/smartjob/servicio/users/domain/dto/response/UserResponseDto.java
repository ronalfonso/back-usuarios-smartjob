package com.smartjob.servicio.users.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String id;
    private String name;
    private String email;
    private LocalDate created;
    private LocalDateTime modified;
    private LocalDate lastLogin;
    private Boolean isActive;
    private List<PhoneResponseDto> phones;

}
