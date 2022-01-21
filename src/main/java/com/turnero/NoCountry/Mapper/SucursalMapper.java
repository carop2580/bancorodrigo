
package com.turnero.NoCountry.Mapper;

import com.turnero.NoCountry.dto.SucursalDTO;
import com.turnero.NoCountry.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class SucursalMapper {
    
    public Sucursal SucursalDTO2Entity(SucursalDTO dto){
        
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());
        sucursal.setCiudad(dto.getCiudad());
        sucursal.setProvincia(dto.getProvincia());
        sucursal.setTelefono(dto.getTelefono());
       
        return sucursal;
    }

    public SucursalDTO SucursalDTO2Entity(Sucursal entidad){
    
        SucursalDTO dto = new SucursalDTO();
        dto.setId_sucursal(entidad.getId_sucursal());
        dto.setNombre(entidad.getNombre());
        dto.setDireccion(entidad.getDireccion());
        dto.setCiudad(entidad.getCiudad());
        dto.setProvincia(entidad.getProvincia());
        dto.setTelefono(entidad.getTelefono());
        
        return dto;
    
    }
    
    public List <SucursalDTO> SucursalList2DTOList (List<Sucursal> entities){
    
        List<SucursalDTO> dtos = new ArrayList<>();
        for (Sucursal sucursal: entities){
            dtos.add(this.SucursalDTO2Entity(sucursal));
        }
        return dtos;
    }

            }