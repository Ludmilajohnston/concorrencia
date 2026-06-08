package com.example.concorrencia.exception;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErro {

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<String> tratarConcorrencia(
            OptimisticLockingFailureException ex
    ) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Conflito de concorrência detectado.");
    }
}
