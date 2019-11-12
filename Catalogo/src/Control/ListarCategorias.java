/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CategoriaDAO;
import Entidad.Categoria;
import Entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class ListarCategorias {
    
    private CategoriaDAO dao = new CategoriaDAO();
    
    public ArrayList<Categoria> validarLista(){
        ArrayList<Categoria> categorias;
        categorias = (ArrayList<Categoria>) dao.leer();
        return categorias;
    }
}
