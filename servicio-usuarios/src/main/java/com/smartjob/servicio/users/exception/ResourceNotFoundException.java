package com.smartjob.servicio.users.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2284734685081556971L;
    private String errorCode;

    /**
     * ResourceNotFoundException
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * ResourceNotFoundException
     *
     * @param message
     * @param errorCode
     */
    public ResourceNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
