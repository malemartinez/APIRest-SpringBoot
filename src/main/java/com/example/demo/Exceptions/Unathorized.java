package com.example.demo.Exceptions;


//Esta excepcion me dice cuando se entra a un path no autorizado. status 401

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Unathorized extends Exception{
    public Unathorized(String message) {
        super(message);
    }
}
