
package com.turnero.NoCountry.repositorios;

import com.turnero.NoCountry.entidades.Usuario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

    @Query("select u from Usuario u where u.username = :username")
    Usuario findByUserName(@Param("username") String username);
    
      @Query("select j from Usuario j where j.username LIKE :query or"
              + "j.sucursal.nombre LIKE :query")
    List<Usuario> findAllByQ(@Param("query") String query);

    @Query("select j from Usuario j where j.id = :id")
    Usuario encontrarPorId(@Param("id") Long id);
    }
    
