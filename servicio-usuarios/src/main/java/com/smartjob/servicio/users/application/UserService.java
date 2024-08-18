package com.smartjob.servicio.users.application;

import com.smartjob.servicio.users.domain.dto.request.UserUpdateRequestDto;
import com.smartjob.servicio.users.domain.dto.request.LoginRequestDto;
import com.smartjob.servicio.users.domain.dto.request.UserRequestDto;
import com.smartjob.servicio.users.domain.dto.response.UserRegisterResponseDto;
import com.smartjob.servicio.users.domain.dto.response.UserResponseDto;
import com.smartjob.servicio.users.domain.entity.Auth;
import com.smartjob.servicio.users.helpers.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
public interface UserService {

    Page<UserResponseDto> findAll(Specification<Auth> spec, Pageable pageable);

    UserResponseDto findById(String id);

    UserRegisterResponseDto register(UserRequestDto userRequestDto);

    UserRegisterResponseDto login(LoginRequestDto userRequestDto);

    UserResponseDto update(String id, UserUpdateRequestDto persona);

    Message delete(String id);

    Auth findAuthById(String id);
}
