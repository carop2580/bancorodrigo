/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turnero.NoCountry.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Rodrigo Caro
 */
@Data
@Entity
public class Producto implements Serializable, Comparable  {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    
    private String producto;

    
    @Override
    public int compareTo(Object t) {
        Producto producto = (Producto) t;
        return this.producto.compareTo(producto.getProducto());
    }
}
