package com.pierluigi.curso.dao;

import com.pierluigi.curso.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface UsuarioDao {

    @Query("SELECT u FROM Usuario ")
    List<Usuario> getUsuarios();

    @Query("SELECT u FROM Usuario u WHERE u.nombre = ?1")
    List<Usuario> findUsuariosByNombre(String nombre);

    @Query("DELETE FROM Usuario u WHERE u.id=:id ")
    void eliminarUsuario(Long id);

    @Query("INSERT INTO Usuario u (u.nombre, u.apellido, u.telefono, u.email, u.password) VALUES (:nombre, :apellido, :telefono, :email, :password)")
    void registrarUsuarios(Usuario usuario);

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")
    boolean verificarCredenciales(Usuario usuario);
}
