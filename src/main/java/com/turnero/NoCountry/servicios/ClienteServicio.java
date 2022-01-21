
package com.turnero.NoCountry.servicios;

import com.turnero.NoCountry.dto.ClienteDTO;
import java.util.List;


public interface ClienteServicio {
    
      ClienteDTO save(ClienteDTO dto);
   
   List<ClienteDTO> getAllClientes();
}
