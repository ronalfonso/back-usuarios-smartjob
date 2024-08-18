package com.smartjob.servicio.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @Project servicio-usuarios
 * @Author raalf on 17/8/2024
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * resourceNotFoundHandling
     *
     * @param exception
     * @param request
     * @return ResponseEntity<?>
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandling(ResourceNotFoundException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * resourceNotFoundHandling
     *
     * @param exception
     * @param request
     * @return ResponseEntity<?>
     */
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> resourceBadRequestHandling(ResourceBadRequestException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceValidationException.class)
    public ResponseEntity<?> resourceValidationExceptionHandling(ResourceValidationException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * resourceUnauthorizedHandling
     *
     * @param exception
     * @param request
     * @return ResponseEntity<?>
     */
    @ExceptionHandler(ResourceUnauthorizedException.class)
    public ResponseEntity<?> resourceUnauthorizedHandling(ResourceUnauthorizedException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                exception.getErrorCode(),
                request.getDescription(false),
                exception.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
}
