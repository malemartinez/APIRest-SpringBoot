package com.example.demo.Validators;

import com.example.demo.Exceptions.UnprocessableEntity;
import com.example.demo.Models.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorClass implements UserValidator{

    public void message(String message) throws UnprocessableEntity{
        throw  new UnprocessableEntity(message);
    }

    @Override
    public void validator(UsuarioModel usuario) throws UnprocessableEntity {

        if( usuario.getNombre() == null || usuario.getNombre().isEmpty() ){
            this.message("El nombre no puede estar vacío");
        }if( usuario.getEmail() == null || usuario.getEmail().isEmpty() ){
            this.message("El email no puede estar vacío");
        }if( usuario.getPrioridad() == null ){
            this.message("Define una prioridad para el usuario");
        }

    }


}
