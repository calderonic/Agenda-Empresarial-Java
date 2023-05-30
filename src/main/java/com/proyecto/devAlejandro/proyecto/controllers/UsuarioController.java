package com.proyecto.devAlejandro.proyecto.controllers;

import com.proyecto.devAlejandro.proyecto.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping (value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Luqwecas");
        usuario.setApellido("11111111111");
        usuario.setTelefono("44231717");
        usuario.setEmail("luqwecasMoy44@gmail.com");
        return usuario;
    }

    @RequestMapping (value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setId(1001L);
        usuario1.setNombre("21321321");
        usuario1.setApellido("assadada");
        usuario1.setTelefono("44231717");
        usuario1.setEmail("luqwecasMoy44@gmail.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(1002L);
        usuario2.setNombre("123123123123");
        usuario2.setApellido("calsdasdas");
        usuario2.setTelefono("44231717");
        usuario2.setEmail("luqwecasMoy44@gmail.com");

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        return usuarios;
    }

    @RequestMapping (value = "usuario2")
    public Usuario modificar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("2222222222222222222");
        usuario.setApellido("Moy");
        usuario.setTelefono("44231717");
        usuario.setEmail("luqwecasMoy44@gmail.com");
        return usuario;
    }
    @RequestMapping (value = "usuario3")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("333333333333333333");
        usuario.setApellido("Moy");
        usuario.setTelefono("44231717");
        usuario.setEmail("luqwecasMoy44@gmail.com");
        return usuario;
    }
    @RequestMapping (value = "usuario4")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Luqwecas");
        usuario.setApellido("Moy");
        usuario.setTelefono("44231717");
        usuario.setEmail("luqwecasMoy44@gmail.com");
        return usuario;
    }

}
