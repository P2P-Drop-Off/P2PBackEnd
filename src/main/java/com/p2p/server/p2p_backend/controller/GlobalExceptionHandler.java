package com.p2p.server.p2p_backend.controller;
import com.p2p.server.p2p_backend.dto.response.GetItemResponse;
import com.p2p.server.p2p_backend.exceptions.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Void> handleNotFound(ItemNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
