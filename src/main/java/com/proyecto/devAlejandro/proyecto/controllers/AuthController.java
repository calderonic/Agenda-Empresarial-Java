package com.proyecto.devAlejandro.proyecto.controllers;


import com.proyecto.devAlejandro.proyecto.dao.UsuarioDao;
import com.proyecto.devAlejandro.proyecto.models.Usuario;
import com.proyecto.devAlejandro.proyecto.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario)  { //estaria convirtiendo el json que recibe a un usuario automaticamente

        Usuario usuarioLogeado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuario != null) {

            String tokenJwt = jwtUtil.create(String.valueOf( usuarioLogeado.getId()), usuarioLogeado.getEmail());
            //IMPLEMENTAR PERMISOS DE USUARIOS, E OTRAS INFORMACION DE USUARIOS
            return tokenJwt;
        }
        return "FAIL";
    }

}
