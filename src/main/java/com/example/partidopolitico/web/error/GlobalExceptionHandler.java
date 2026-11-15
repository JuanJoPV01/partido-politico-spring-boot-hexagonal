package com.example.partidopolitico.web.error;

import com.example.partidopolitico.domain.Exceptions.PartidoPoliticoAlreadyExistsException;
import com.example.partidopolitico.domain.Exceptions.PartidoPoliticoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PartidoPoliticoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePartidoPoliticoNotFound(PartidoPoliticoNotFoundException ex) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(PartidoPoliticoAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlePartidoPoliticoAlreadyExists(PartidoPoliticoAlreadyExistsException ex) {
        return build(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(RuntimeException ex) {
        return build(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResource(NoResourceFoundException ex) {
        return build(HttpStatus.NOT_FOUND, "El recurso solicitado no existe");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
    }

    private ResponseEntity<ErrorResponse> build(HttpStatus status, String message) {
        ErrorResponse error = ErrorResponse.of(status.value(), status.getReasonPhrase(), message);
        return ResponseEntity.status(status).body(error);
    }
}