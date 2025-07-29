/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Producto;

/**
 *
 * @author wilde
 */
public class ModificarProducto {
    
    private ProductoDAO dao = new ProductoDAO();
    
    public String validarModificarProducto(Producto producto, Producto productoNuevo){    
        if(!verificarLongitudDescripcion(productoNuevo.getDescripcion())){
            return ("La longitud de la nueva descripción es incorrecta");
        }
        if(!verificarCantidadPrecio(productoNuevo.getPrecio())){
            return ("El nuevo precio es incorrecto");
        }
        if(!dao.actualizar(producto, productoNuevo)){
            return("No se pudo modificar el producto");
        }
        return ("Producto modificado con exito");
    }
    
    private boolean verificarLongitudDescripcion(String descripcion){
        return (descripcion.length() >= 5 && descripcion.length() <= 50);
    }
    
    private boolean verificarCantidadPrecio(int precio){
        return (precio >= 0);
    }
}
