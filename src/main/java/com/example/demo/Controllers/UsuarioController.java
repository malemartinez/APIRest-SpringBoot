package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.Exceptions.UnprocessableEntity;
import com.example.demo.Models.UsuarioModel;
import com.example.demo.Services.UsuarioService;

import com.example.demo.Validators.UserValidatorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    UserValidatorClass userValidatorClass;


    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) throws UnprocessableEntity {
            this.userValidatorClass.validator(usuario);
        return this.usuarioService.guardarUsuario(usuario);
    }

    @PatchMapping(path = "/{id}")
    public void ActualizarEmail(@RequestParam("email")  String email, @PathVariable("id") Long id){
        this.usuarioService.actualizarEmail(email ,id);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
