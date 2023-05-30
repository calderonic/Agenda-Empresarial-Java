package com.proyecto.devAlejandro.proyecto.dao;

import com.proyecto.devAlejandro.proyecto.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements  UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Usuario> getUsuario() {
         String query = "FROM Usuario"; //trabaja sobre hibernate,datos de la clase.
       // List<Usuario> resultado = entityManager.createQuery(query).getResultList();
       // return resultado;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }
}
