
package com.turnero.NoCountry.Mapper;

import com.turnero.NoCountry.dto.UsuarioDTO;
import com.turnero.NoCountry.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    
    public Usuario UsuarioDTO2Entity(UsuarioDTO dto){
        
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        
        return usuario;
    }

    public UsuarioDTO UsuarioDTO2Entity(Usuario entidad){
    
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId_usuario(entidad.getId_usuario());
        dto.setUsername(entidad.getUsername());
        dto.setPassword(entidad.getPassword());
        dto.setRol(entidad.getRol());
        
        return dto;
    
    }
    
    public List <UsuarioDTO> UsuarioList2DTOList (List<Usuario> entities){
    
        List<UsuarioDTO> dtos = new ArrayList<>();
        for (Usuario usuario: entities){
            dtos.add(this.UsuarioDTO2Entity(usuario));
        }
        return dtos;
    }

}
