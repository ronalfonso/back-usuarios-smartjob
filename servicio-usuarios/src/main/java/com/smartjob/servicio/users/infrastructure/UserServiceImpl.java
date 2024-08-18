package com.smartjob.servicio.users.infrastructure;

import com.smartjob.servicio.users.application.UserService;
import com.smartjob.servicio.users.domain.dto.request.UserUpdateRequestDto;
import com.smartjob.servicio.users.domain.dto.request.LoginRequestDto;
import com.smartjob.servicio.users.domain.dto.request.UserRequestDto;
import com.smartjob.servicio.users.domain.dto.response.PhoneResponseDto;
import com.smartjob.servicio.users.domain.dto.response.UserRegisterResponseDto;
import com.smartjob.servicio.users.domain.dto.response.UserResponseDto;
import com.smartjob.servicio.users.domain.entity.Auth;
import com.smartjob.servicio.users.domain.entity.Phone;
import com.smartjob.servicio.users.domain.entity.User;
import com.smartjob.servicio.users.exception.ResourceUnauthorizedException;
import com.smartjob.servicio.users.mappers.Mapper;
import com.smartjob.servicio.users.repository.AuthRepository;
import com.smartjob.servicio.users.repository.UserRepository;
import com.smartjob.servicio.users.exception.ResourceBadRequestException;
import com.smartjob.servicio.users.exception.ResourceNotFoundException;
import com.smartjob.servicio.users.helpers.Message;
import com.smartjob.servicio.users.utils.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.smartjob.servicio.users.mappers.AuthMapper.*;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthRepository authRepository;

    @Override
    public Page<UserResponseDto> findAll(Specification<Auth> spec, Pageable pageable) {
        return Mapper.mapPage(authRepository.findAll(spec, pageable), UserResponseDto.class);
    }

    @Override
    public UserResponseDto findById(String id) {
        Auth user = authRepository.findById(UUID.fromString(id))
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro un usuario con el id: " + id));
        UserResponseDto userResponseDto = toUserResponseDto(user);
        userResponseDto.setPhones(Mapper.mapAll(user.getPhones(), PhoneResponseDto.class));

        return userResponseDto;
    }

    @Override
    public UserRegisterResponseDto register(UserRequestDto userRequestDto) {
        if (emailExist(userRequestDto.getEmail())) {
            throw new ResourceBadRequestException("El correo ya existe");
        }

        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());

        User user = authRepository.save(requestToUser(userRequestDto, encodedPassword));

        Auth auth = authRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No existe un usuario con ese ID"));

        auth.setToken(jwtService.generateToken(String.valueOf(user.getId())));
        auth.setLastLogin(user.getCreated());

        authRepository.save(auth);

        return toAuthResponseDTO(auth);
    }

    @Override
    public UserRegisterResponseDto login(LoginRequestDto userRequestDto) {
        Auth user = authRepository.findByEmail(userRequestDto.getEmail())
                .orElseThrow(() -> new ResourceUnauthorizedException("Email o password invalidos"));
        boolean authenticate = passwordEncoder.matches(userRequestDto.getPassword(), user.getPassword());
        if (!authenticate) {
            throw new ResourceUnauthorizedException("Email o password invalidos");
        }
        if (!user.getIsActive()) {
            throw new ResourceUnauthorizedException("El usuario esta inactivo, comuniquese con el administrador del sistema");
        }
        user.setLastLogin(LocalDate.now());
        authRepository.save(user);

        return toAuthResponseDTO(user);
    }

    @Override
    public UserResponseDto update(String id, UserUpdateRequestDto userUpdateRequestDto) {
        Auth userByUpdate = authRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceBadRequestException("El usuario con ese el id: "+ id+" no existe"));

        userByUpdate.setName(userUpdateRequestDto.getName());
        userByUpdate.setIsActive(userUpdateRequestDto.isActive());
        userByUpdate.setPhones(userUpdateRequestDto.getPhones().stream().map(phone -> Mapper.map(phone, Phone.class)).collect(Collectors.toList()));

        return Mapper.map(authRepository.save(userByUpdate), UserResponseDto.class);
    }

    @Override
    public Message delete(String id) {
        if (!userExist(id)) {
            throw new ResourceBadRequestException("El usuario con ese el id: "+ id+" no existe");
        }
        authRepository.deleteById(UUID.fromString(id));
        return new Message("usuario eliminado con éxito");
    }

    @Override
    public Auth findAuthById(String id) {
        return authRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceAccessException("El usuario con ese el id: "+ id+" no existe"));
    }

    private boolean userExist(String id) {
        return userRepository.existsById(UUID.fromString(id));
    }

    private boolean emailExist(String email) {
        return userRepository.existsByEmail(email);
    }
}
