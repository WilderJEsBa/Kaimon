/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Producto;
import java.util.List;

/**
 *
 * @author wilde
 */
public class BuscarProducto {
    
    private ProductoDAO dao = new ProductoDAO();
    
    public List<Producto> realizarBusqueda(String busqueda){
        List<Producto> productos;
        if(busqueda.equals("")){
            productos = dao.leer();
        }
        else{
            productos =  dao.leer(busqueda);
        }
        return productos;
    }
    
}
