package com.senac.tsi.FichasRPG.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TagNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleTagNotFound(TagNotFoundException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timeStamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "NotFound");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(RpgValidationException.class)
    public ResponseEntity<Map<String,Object>> handleBadInput(RpgValidationException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("timeStamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad request");
        body.put("message", ex.getMessage());
        body.put("process:",ex.getProcesso());
        body.put("wrong parameter: ",ex.getParametroErrado());
        body.put("expected parameter: ", ex.getParametroEsperado());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
