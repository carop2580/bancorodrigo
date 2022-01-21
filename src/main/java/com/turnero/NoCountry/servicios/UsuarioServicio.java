
package com.turnero.NoCountry.servicios;

import com.turnero.NoCountry.dto.UsuarioDTO;
import java.util.List;


public interface UsuarioServicio {
    
    UsuarioDTO save(UsuarioDTO dto);
   
   List<UsuarioDTO> getAllUsuarios();

    public Object getAllUsuarios(String q);
}
