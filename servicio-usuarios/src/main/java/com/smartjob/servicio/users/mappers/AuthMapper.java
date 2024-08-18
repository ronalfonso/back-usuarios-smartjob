package com.smartjob.servicio.users.mappers;


import com.smartjob.servicio.users.domain.dto.request.PhoneRequestDto;
import com.smartjob.servicio.users.domain.dto.request.UserRequestDto;
import com.smartjob.servicio.users.domain.dto.response.UserRegisterResponseDto;
import com.smartjob.servicio.users.domain.dto.response.UserResponseDto;
import com.smartjob.servicio.users.domain.entity.Auth;
import com.smartjob.servicio.users.domain.entity.Phone;

import java.util.stream.Collectors;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
public class AuthMapper {

    public static UserRegisterResponseDto toAuthResponseDTO(Auth auth) {
        return UserRegisterResponseDto.builder()
                .id(auth.getId())
                .created(auth.getCreated())
                .modified(auth.getModified())
                .lastLogin(auth.getLastLogin())
                .token(auth.getToken())
                .isActive(auth.getIsActive())
                .build();
    }

    public static UserResponseDto toUserResponseDto(Auth auth) {
        return UserResponseDto.builder()
                .name(auth.getName())
                .email(auth.getEmail())
                .created(auth.getCreated())
                .modified(auth.getModified())
                .isActive(auth.getIsActive())
                .lastLogin(auth.getLastLogin())
                .build();
    }



    public static Auth requestToUser(UserRequestDto userRequestDto, String encodedPassword) {
        return Auth.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .password(encodedPassword)
                .phones(userRequestDto.getPhones().stream().map(AuthMapper::phoneRequestToPhone).collect(Collectors.toList()))
                .isActive(true)
                .build();
    }

    public static Phone phoneRequestToPhone(PhoneRequestDto phone) {
        return Phone.builder()
                .number(phone.getNumber())
                .cityCode(phone.getCityCode())
                .countryCode(phone.getCountryCode())
                .build();
    }

}
