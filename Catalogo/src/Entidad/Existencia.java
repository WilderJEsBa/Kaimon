/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ACER
 */

@Entity
@Table (name="existencias")
public class Existencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoExistencia;
    private int cantidad;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne(targetEntity=Producto.class )
    private Producto producto;

    public Existencia() {
    }
    

    public int getCodigoExistencia() {
        return codigoExistencia;
    }

    public void setCodigoExistencia(int codigoExistencia) {
        this.codigoExistencia = codigoExistencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
