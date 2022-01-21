
package com.turnero.NoCountry.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    
    private Long id_cliente;
    
    private String nombre;
    
    private String apellido;
    
    private String dni;
    
     private Date FechaNacimiento;    
    private String direccion;    
    private String cp;
    
    private String provincia;     
    
    private String telefono;
    
      private String Ciudad; 
   
    
    private String email;
    
     private Long id_TipoCliente;
}
