/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnero.NoCountry.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rodrigo Caro
 */
@Getter
@Setter
@Entity
public class Cliente implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    
    private String nombre;
    
    private String apellido;
    
    private String dni;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date FechaNacimiento;    
    private String direccion;    
    private String cp;
    
    private String provincia;     
    
    private String telefono;
    
  
    private String Ciudad; 
   
    
    private String email;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "tipo_cliente_id", insertable = false, updatable = false)
    private TipoCliente tipoCliente;
    
    @Column(name = "id_TipoCliente", nullable = false)
    private Long id_TipoCliente;
}
