package com.proyecto.devAlejandro.proyecto.dao;

import com.proyecto.devAlejandro.proyecto.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface UsuarioDao {

    List<Usuario> getUsuario();

    void eliminarUsuario(Long id);

    void registrar(Usuario usuario);


    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
