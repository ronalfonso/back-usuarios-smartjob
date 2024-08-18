package com.smartjob.servicio.users.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@Data
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private int status;
    private HttpStatus error;
    private String errorCode;
    private String path;
    private StackTraceElement[] errors;

    /**
     * ErrorDetails
     *
     * @param timestamp
     * @param message
     * @param status
     * @param error
     * @param errorCode
     * @param path
     * @param errors
     */
    public ErrorDetails(Date timestamp, String message, int status, HttpStatus error, String errorCode,
                        String path, StackTraceElement[] errors) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
        this.path = path.replace("uri=", "");
        this.errors = errors;
    }
}
