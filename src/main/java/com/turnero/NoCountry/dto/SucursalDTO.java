
package com.turnero.NoCountry.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SucursalDTO {
    private Long id_sucursal;
    private String nombre;
    private String direccion;
    private String Telefono;
    private String Email;
    private String provincia;
    private String ciudad;
}
