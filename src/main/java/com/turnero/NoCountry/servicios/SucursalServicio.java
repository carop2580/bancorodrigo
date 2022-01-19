
package com.turnero.NoCountry.servicios;

import com.turnero.NoCountry.dto.SucursalDTO;
import java.util.List;


public interface SucursalServicio {
    
   SucursalDTO save(SucursalDTO dto);
   
   List<SucursalDTO> getAllSucursales();
}
