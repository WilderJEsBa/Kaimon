/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Categoria;
import Entidad.Producto;

/**
 *
 * @author wilde
 */
public class AgregarProducto {
    
    private ProductoDAO dao = new ProductoDAO();
    
    public String validarAgregarProducto(Producto producto){
        if(!verificarLongitudNombre(producto.getNombreProducto())){
            return ("La longitud del nombre es incorrecta");
        }
        if(verificarProductoExiste(producto)){
            return ("El producto ya existe");
        }
        if(!verificarLongitudDescripcion(producto.getDescripcion())){
            return ("La longitud de la descripción es incorrecta");
        }
        if(!verificarPrecio(producto.getPrecio())){
            return ("El precio es incorrecto");
        }
        dao.crear(producto);
        return ("Producto añadido con exito");
    }
    
    private boolean verificarLongitudNombre(String nombre){
        return (nombre.length() >=4 && nombre.length() <= 16);
    }
    
    private boolean verificarProductoExiste(Producto producto){
        return (dao.leer(producto) != null);
    }
    
    private boolean verificarLongitudDescripcion(String descripcion){
        return (descripcion.length() >= 5 && descripcion.length() <= 50);
    }
    
    private boolean verificarPrecio(int precio){
        return (precio >= 0);
    }
    
}
