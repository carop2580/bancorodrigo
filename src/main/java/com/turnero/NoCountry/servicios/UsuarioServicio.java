
package com.turnero.NoCountry.servicios;

import com.turnero.NoCountry.dto.UsuarioDTO;
import com.turnero.NoCountry.entidades.Usuario;
import java.util.List;


public interface UsuarioServicio {
    
    UsuarioDTO save(UsuarioDTO dto);
   
   List<UsuarioDTO> getAllUsuarios();

  
    public List<Usuario> findAllByQ(String q);
}