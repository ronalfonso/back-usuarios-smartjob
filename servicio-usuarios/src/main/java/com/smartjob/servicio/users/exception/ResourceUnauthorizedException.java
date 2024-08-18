package com.smartjob.servicio.users.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ResourceUnauthorizedException extends RuntimeException {
    private String errorCode;

    /**
     * ResourceUnauthorizedException
     *
     * @param message
     */
    public ResourceUnauthorizedException(String message) {
        super(message);
    }

    /**
     * ResourceUnauthorizedException
     *
     * @param message
     * @param errorCode
     */
    public ResourceUnauthorizedException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}