package com.example.demo.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta excepcion me dice cuando una entidad enviado no tiene el formato adecuado. status 422
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends Exception{

    private String message;

    public UnprocessableEntity(String message) {
        super(message);
    }
}
