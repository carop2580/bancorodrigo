
package com.turnero.NoCountry.dto;

import com.turnero.NoCountry.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id_usuario;
    private String username;
    private String password;
    private Role rol;
}
