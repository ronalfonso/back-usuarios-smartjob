package com.smartjob.servicio.users.interfaces;

import com.smartjob.servicio.users.application.UserService;
import com.smartjob.servicio.users.domain.dto.request.UserUpdateRequestDto;
import com.smartjob.servicio.users.domain.dto.request.LoginRequestDto;
import com.smartjob.servicio.users.domain.dto.request.UserRequestDto;
import com.smartjob.servicio.users.domain.dto.response.UserRegisterResponseDto;
import com.smartjob.servicio.users.domain.dto.response.UserResponseDto;
import com.smartjob.servicio.users.domain.entity.Auth;
import com.smartjob.servicio.users.helpers.Message;
import com.smartjob.servicio.users.specification.UsersSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<UserResponseDto>> findAll(UsersSpecification spec, Pageable pageable) {
        return new ResponseEntity<Page<UserResponseDto>>(userService.findAll(spec, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> details(@PathVariable String id) {
        return new ResponseEntity<UserResponseDto>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> create(@RequestBody UserRequestDto personaRequestDto) {
        return new ResponseEntity<UserRegisterResponseDto>(userService.register(personaRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserRegisterResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<UserRegisterResponseDto>(userService.login(loginRequestDto), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable String id, @RequestBody UserUpdateRequestDto personaRequestDto) {
        return new ResponseEntity<UserResponseDto>(userService.update(id, personaRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> delete(@PathVariable String id) {
        return new ResponseEntity<Message>(userService.delete(id), HttpStatus.OK);
    }
}
