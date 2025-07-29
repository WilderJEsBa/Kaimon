/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wilde
 */


@Entity
@Table (name="pedidoitems")
public class PedidoItem implements Serializable {
    
    @Id
    private int codigoItem;
    private int precioActualItem;
    private int cantidadItem;
    private int subtotalItem;
    @OneToOne(targetEntity=Producto.class)
    private Producto producto;

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getPrecioActualItem() {
        return precioActualItem;
    }

    public void setPrecioActualItem(int precioActualItem) {
        this.precioActualItem = precioActualItem;
    }

    public int getCantidadItem() {
        return cantidadItem;
    }

    public void setCantidadItem(int cantidadItem) {
        this.cantidadItem = cantidadItem;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getSubtotalItem() {
        return subtotalItem;
    }

    public void setSubtotalItem(int subtotalItem) {
        this.subtotalItem = subtotalItem;
    }
    
}
