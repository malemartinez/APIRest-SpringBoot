package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta excepcion me dice cuando algo no es encontrado. status 404

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends Exception{

    public NotFound(String message) {
        super(message);
    }
}
