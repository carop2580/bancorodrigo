
package com.turnero.NoCountry.Mapper;

import com.turnero.NoCountry.dto.ClienteDTO;
import com.turnero.NoCountry.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    
    public Cliente ClienteDTO2Entity(ClienteDTO dto){
        
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        cliente.setCiudad(dto.getCiudad());
        cliente.setCp(dto.getCp());
        cliente.setProvincia(dto.getProvincia());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setId_TipoCliente(dto.getId_TipoCliente());
        
       
        return cliente;
    }

    public ClienteDTO ClienteDTO2Entity(Cliente entidad){
    
        ClienteDTO dto = new ClienteDTO();
        dto.setId_cliente(entidad.getId_cliente());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setCiudad(entidad.getCiudad());
        dto.setCp(entidad.getCp());
        dto.setProvincia(entidad.getProvincia());
        dto.setTelefono(entidad.getTelefono());
        dto.setEmail(entidad.getEmail());
        dto.setId_TipoCliente(entidad.getId_TipoCliente());
        
        return dto;
    
    }
    
    public List <ClienteDTO> ClienteList2DTOList (List<Cliente> entities){
    
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente: entities){
            dtos.add(this.ClienteDTO2Entity(cliente));
        }
        return dtos;
    }
}
