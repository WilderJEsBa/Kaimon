/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author wilde
 */
public class BuscarProducto {
    
    private ProductoDAO dao = new ProductoDAO();
    
    public ArrayList<Producto> realizarBusqueda(String busqueda){
        ArrayList<Producto> productos;
        productos = (ArrayList<Producto>) dao.leer(busqueda);
        return productos;
    }
    
}
