
package com.turnero.NoCountry.servicios.Impl;


import com.turnero.NoCountry.Mapper.SucursalMapper;
import com.turnero.NoCountry.dto.SucursalDTO;
import com.turnero.NoCountry.entidades.Sucursal;
import com.turnero.NoCountry.excepciones.WebException;
import com.turnero.NoCountry.repositorios.SucursalRepositorio;
import com.turnero.NoCountry.servicios.SucursalServicio;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SucursalServicioImpl implements SucursalServicio {
    
     @Autowired
    private SucursalRepositorio sucursalRepositorio;
     @Autowired
     private SucursalMapper sucursalMapper;
     
     public SucursalDTO save(SucursalDTO dto){
        Sucursal entidad = sucursalMapper.SucursalDTO2Entity(dto);
        Sucursal entitySaved = sucursalRepositorio.save(entidad);
        SucursalDTO result = sucursalMapper.SucursalDTO2Entity(entitySaved);
        return result;
     }

    
    public List<SucursalDTO> getAllSucursales() {
    
        List <Sucursal> entities = sucursalRepositorio.findAll();
        List <SucursalDTO> result = sucursalMapper.SucursalList2DTOList(entities);
        return result;
    }
}

  

 /*   public Sucursal save(Sucursal sucursal) throws WebException, IOException {
        
        
        if (sucursal.getTelefono().isEmpty() || sucursal.getTelefono()== null) {
            throw new WebException("Debe ingresar el telefono de la sucursal");
        }

        if (sucursal.getDireccion().isEmpty() || sucursal.getDireccion()== null) {
            throw new WebException("Debe ingresar la direccion de la sucursal");
        }

       if (sucursal.getEmail().isEmpty() || sucursal.getEmail()== null) {
            throw new WebException("Debe ingresar email de la sucursal");
        }
       
       
        return sucursalRepositorio.save(sucursal);

    }

    public List<Sucursal> listAll() {
        List<Sucursal> lista = sucursalRepositorio.findAll();
        return lista;
    }


    public List<Sucursal> listallByQ(String query) {
        List<Sucursal> lista = sucursalRepositorio.findAllByQ("%" + query + "%");
        return lista;
    }

    public Optional<Sucursal> findById(String id) {
        return sucursalRepositorio.findById(id);
    }

    public Sucursal findById2(Sucursal sucursal) {
        Optional<Sucursal> optional1 = sucursalRepositorio.findById(sucursal.getId());
        if (optional1.isPresent()) {
            sucursal = optional1.get();
        }
        return sucursal;
    }

    @Transactional
    public void delete(Sucursal sucursal) {
        sucursalRepositorio.delete(sucursal);
    }

    @Transactional
    public void deleteById(String id) {
        Optional<Sucursal> optional =sucursalRepositorio.findById(id);
        if (optional.isPresent()) {
            sucursalRepositorio.delete(optional.get());
        }
    }

    public Sucursal encontrarPorId(String id) {
        return sucursalRepositorio.encontrarPorId(id);
    }

    public SucursalDTO save(SucursalDTO sucursal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/


