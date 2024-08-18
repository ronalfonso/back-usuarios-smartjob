package com.smartjob.servicio.users.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceValidationException extends RuntimeException {
    private String errorCode;

    public ResourceValidationException(String message) {
        super(message);
    }

    public ResourceValidationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
