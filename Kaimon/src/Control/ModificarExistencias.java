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
public class ModificarExistencias {
    
    private ProductoDAO dao = new ProductoDAO();
    
    public String validarmodificarExistencias(Producto producto, int cantidad){
        if(!verificarCantidadProducto(cantidad)){
            return ("La cantidad es incorrecta");
        }
        dao.actualizarExistencia(producto, cantidad);
        return ("Modificacion exitosa");
    }
    
    private boolean verificarCantidadProducto(int cantidad){
        return (cantidad >= 0);
    }
}
