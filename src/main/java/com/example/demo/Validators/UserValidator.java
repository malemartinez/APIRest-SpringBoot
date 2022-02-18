package com.example.demo.Validators;

import com.example.demo.Exceptions.UnprocessableEntity;
import com.example.demo.Models.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public interface UserValidator {
    void validator(UsuarioModel usuario) throws UnprocessableEntity;

}
