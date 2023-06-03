package com.proyecto.devAlejandro.proyecto.controllers;


import com.proyecto.devAlejandro.proyecto.dao.UsuarioDao;
import com.proyecto.devAlejandro.proyecto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario)  { //estaria convirtiendo el json que recibe a un usuario automaticamente

        if(usuarioDao.verificarCredenciales(usuario)) {
            return "OK";
        }
        return "FAIL";
    }

}
