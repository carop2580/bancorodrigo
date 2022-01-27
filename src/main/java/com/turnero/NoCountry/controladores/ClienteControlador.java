
package com.turnero.NoCountry.controladores;

import com.turnero.NoCountry.dto.ClienteDTO;

import com.turnero.NoCountry.servicios.ClienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/Cliente")
public class ClienteControlador {
    
        @Autowired
    private ClienteServicio clienteServicio;

   @GetMapping  
   public ResponseEntity <List<ClienteDTO>> getAll(){
       List<ClienteDTO> clientees = clienteServicio.getAllClientes();
       return ResponseEntity.ok().body(clientees);
    }
    @PostMapping
    public ResponseEntity <ClienteDTO> save (@RequestBody ClienteDTO cliente){
    
        ClienteDTO sucursalGaurdada = clienteServicio.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalGaurdada);
    }
}
