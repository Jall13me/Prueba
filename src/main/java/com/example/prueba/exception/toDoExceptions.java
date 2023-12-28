package com.example.prueba.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class toDoExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public toDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
