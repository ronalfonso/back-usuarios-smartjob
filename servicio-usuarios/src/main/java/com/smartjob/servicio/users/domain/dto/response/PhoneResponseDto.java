package com.smartjob.servicio.users.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponseDto {
    private String id;
    private String number;
    private String cityCode;
    private String countryCode;
}
