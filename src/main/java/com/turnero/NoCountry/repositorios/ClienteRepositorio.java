
package com.turnero.NoCountry.repositorios;

import com.turnero.NoCountry.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
     @Query("select j from Cliente j where j.nombre LIKE :query")
    List<Cliente> findAllByQ(@Param("query") String query);

    @Query("select j from Cliente j where j.id = :id")
    Cliente encontrarPorId(@Param("id") String id);

    @Query("select j from Cliente j where j.provincia.provincia = :q")
    List<Cliente> findAllByProvincia(@Param("q") String q);

    @Query("select j from Cliente j where j.ciudad.ciudad = :q")
    List<Cliente> findAllByCiudad(@Param("q") String q);

    @Override
    @Query("select j from Cliente j order by j.nombre")
    List<Cliente> findAll();
}
