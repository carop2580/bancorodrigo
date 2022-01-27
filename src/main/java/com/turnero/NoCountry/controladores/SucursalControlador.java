
package com.turnero.NoCountry.controladores;

import com.turnero.NoCountry.dto.SucursalDTO;
import com.turnero.NoCountry.excepciones.WebException;
import com.turnero.NoCountry.servicios.SucursalServicio;



import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/sucursal")
public class SucursalControlador {
    
     @Autowired
    private SucursalServicio sucursalServicio;

   @GetMapping  
   public ResponseEntity <List<SucursalDTO>> getAll(){
       List<SucursalDTO> Sucursales = sucursalServicio.getAllSucursales();
       return ResponseEntity.ok().body(Sucursales);
   }

    
    //@PreAuthorize("hasAnyRole('ROLE_USER')")
    /*@GetMapping("/list")
    public String listarSucursales(Model model, @RequestParam(required = false) String q) {
        if (q != null) {
            model.addAttribute("sucursales", sucursalServicio.listallByQ(q));
        } else {
            model.addAttribute("sucursales", sucursalServicio.listAll());
        }
        return "sucursal-list";
    }

    @GetMapping("/form")
    public String crearSucursal(Model model, @RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Sucursal> optional = sucursalServicio.findById(id);
            if (optional.isPresent()) {
                model.addAttribute("sucursal", optional.get());
            } else {
                return "redirect:/sucursal/list";
            }
        } else {
            model.addAttribute("sucursal", new Sucursal());
        }/*
        model.addAttribute("ciudades", ciudadServicio.listAll());
        model.addAttribute("provincias", provinciaServicio.listAll());
        
        
        */
       // return "sucursal-form";
    
    @PostMapping
    public ResponseEntity <SucursalDTO> save (@RequestBody SucursalDTO sucursal){
    
        SucursalDTO sucursalGaurdada = sucursalServicio.save(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalGaurdada);
    }

   /* @PostMapping("/save")
    public String guardarSucursal(Model model, RedirectAttributes redirectAttributes, Sucursal sucursal) throws IOException {

        try {
            sucursalServicio.save(sucursal);
            redirectAttributes.addFlashAttribute("error", "Primer paso completado exitosamente");
        } catch (WebException ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("sucursal", sucursal);
            /*
        model.addAttribute("ciudades", ciudadServicio.listAll());
        model.addAttribute("provincias", provinciaServicio.listAll());
        */
          //  return "sucursal-form";
       // }
      //  return "redirect:/";
   //}

   // @GetMapping("/delete")
  //  public String delete(@RequestParam(required = true) String id) {
      //  sucursalServicio.deleteById(id);
      //  return "redirect:/sucursal/list";
   // }

  
}
