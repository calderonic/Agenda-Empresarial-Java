package com.proyecto.devAlejandro.proyecto.dao;

import com.proyecto.devAlejandro.proyecto.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface UsuarioDao {

    List<Usuario> getUsuario();
}
