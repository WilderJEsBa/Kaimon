/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ExistenciaDAO;
import Entidad.Existencia;
import java.util.Date;

/**
 *
 * @author wilde
 */
public class ModificarExistencias {
    
    private ExistenciaDAO dao = new ExistenciaDAO();
    
    public String validarmodificarExistencias(Existencia existencia){
        return null;
    }
    
    private boolean verificarCantidadExistencia(int cantidad){
        return (cantidad >= 0);
    }
    
    private boolean verificarFechaExistencia(Date fecha){
        return (false);
    }
}
