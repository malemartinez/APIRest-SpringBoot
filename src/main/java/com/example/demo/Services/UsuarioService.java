package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.Exceptions.UnprocessableEntity;
import com.example.demo.Models.UsuarioModel;
import com.example.demo.Repositories.UsuarioRepository;

import com.example.demo.Validators.UserValidator;
import com.example.demo.Validators.UserValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    UserValidatorClass userValidatorClass;


    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ResponseEntity<String> guardarUsuario(UsuarioModel usuario) {
        try{

            usuarioRepository.save(usuario);
        return new ResponseEntity<>( "", HttpStatus.OK);
    }
        catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
    }}

    public Optional<UsuarioModel> obtenerPorId(Long id){
            return usuarioRepository.findById(id);
    }


    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    //modificar el email
    public void actualizarEmail(String email , Long id){
        Optional<UsuarioModel> users = this.usuarioRepository.findById(id);
        UsuarioModel user = users.get();
        user.setEmail(email);
        usuarioRepository.save(user);

    }



}