/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CategoriaDAO;
import Entidad.Categoria;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class ListarCategorias {
    
    private CategoriaDAO dao = new CategoriaDAO();
    
    public List<Categoria> validarLista(){
        List<Categoria>categorias;
        categorias = (List<Categoria>) dao.leer();
        return categorias;
    }
}
