
package com.turnero.NoCountry.servicios.Impl;

import com.turnero.NoCountry.Mapper.ClienteMapper;
import com.turnero.NoCountry.dto.ClienteDTO;
import com.turnero.NoCountry.entidades.Cliente;
import com.turnero.NoCountry.repositorios.ClienteRepositorio;
import com.turnero.NoCountry.servicios.ClienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServicioImpl implements ClienteServicio {
    
     @Autowired
    private ClienteRepositorio clienteRepositorio;
     @Autowired
     private ClienteMapper clienteMapper;
     
     public ClienteDTO save(ClienteDTO dto){
        Cliente entidad = clienteMapper.ClienteDTO2Entity(dto);
        Cliente entitySaved = clienteRepositorio.save(entidad);
        ClienteDTO result = clienteMapper.ClienteDTO2Entity(entitySaved);
        return result;
     }

    
    public List<ClienteDTO> getAllClientees() {
    
        List <Cliente> entities = clienteRepositorio.findAll();
        List <ClienteDTO> result = clienteMapper.ClienteList2DTOList(entities);
        return result;
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
