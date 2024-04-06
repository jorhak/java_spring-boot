package com.pierluigi.curso.dao;

import com.pierluigi.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        String query = "SELECT u FROM Usuario u";
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }

    @Override
    public List<Usuario> findUsuariosByNombre(String nombre) {
        String query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
        return entityManager.createQuery(query, Usuario.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    @Override
    public void eliminarUsuario(Long id) {
        String query = "DELETE FROM Usuario u WHERE u.id=:id";
        entityManager.createQuery(query).
                setParameter("id",id).
                executeUpdate();
    }

    @Override
    public void registrarUsuarios(Usuario usuario) {
        String query = "INSERT INTO usuario (nombre, apellido, telefono, email, password) " +
                "VALUES (:nombre, :apellido, :telefono, :email, :password)";

        entityManager.createNativeQuery(query)
                .setParameter("nombre", usuario.getNombre())
                .setParameter("apellido", usuario.getApellido())
                .setParameter("telefono", usuario.getTelefono())
                .setParameter("email", usuario.getEmail())
                .setParameter("password", usuario.getPassword())
                .executeUpdate();
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "SELECT u FROM Usuario u WHERE u.email = :email ";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return false;
        }
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashed, usuario.getPassword());
    }


}
