package com.proyecto.devAlejandro.proyecto.dao;

import com.proyecto.devAlejandro.proyecto.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    @Transactional  //configuracion llamado "modo de propagacion"
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

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
  //     String query = "FROM Usuario WHERE email = :email AND password = :password";//trabaja sobre hibernate,datos de la clase.
  //     List<Usuario> listaDB = entityManager.createQuery(query)
  //         .setParameter("email",usuario.getEmail())
  //             .setParameter("password", usuario.getPassword())
  //             .getResultList();

        String query = "FROM Usuario WHERE email = :email";//trabaja sobre hibernate,datos de la clase.
        List<Usuario> listaDB = entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .getResultList();

        if(listaDB.isEmpty()) {
            return false;
        }



        String passwordHashed = listaDB.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return argon2.verify(passwordHashed, usuario.getPassword()  ) ;
    }

}
