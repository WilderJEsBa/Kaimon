/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CategoriaDAO;
import Entidad.Categoria;

/**
 *
 * @author wilde
 */
public class AgregarCategoria {
    
    private CategoriaDAO dao = new CategoriaDAO();
    
    public String validarAgregarCategoria(Categoria categoria){
        if(!verificarLongitudNombre(categoria.getNombreCategoria())){
            return ("La longitud del nombre es incorrecta");
        }
        if(!verificarCategoriaExiste(categoria)){
            return ("La categoria ya existe");
        }
        dao.crear(categoria);
        return ("Categoria creada con exito");
    }
    
    private boolean verificarLongitudNombre(String nombre){
        return (nombre.length() >=4 && nombre.length() <= 16);
    }
    
    private boolean verificarCategoriaExiste(Categoria categoria){
        return (dao.leer(categoria) != null);
    }
}
