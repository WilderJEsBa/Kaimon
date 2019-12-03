/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.LocalDAO;
import Entidad.Local;

/**
 *
 * @author wilde
 */
public class ValidarLogin {
    
    private LocalDAO dao = new LocalDAO();

    public ValidarLogin() {
    }
    
    public String verificarLogin(Local local) {
        if (!verificarLongitudNombreAdministrador(local.getNombreAdministrador())) {
            return ("La longitud del nombre del administrador es incorrecta");
        }
        if (!verificarLongitudContrasenia(local.getContraseña())) {
            return ("La longitud de la contraseña es incorrecta");
        }
        if(dao.leer(local) != null){
            return ("Ingreso exitoso");
        }
        return ("Datos incorrectos");
    }
    
    private boolean verificarLongitudNombreAdministrador(String nombreAdministrador){
        return (nombreAdministrador.length() >= 4 && nombreAdministrador.length() <= 50);
    }
    
    private boolean verificarLongitudContrasenia(String contraseña){
        return (contraseña.length() >= 4 && contraseña.length() <= 50);
    }
    
}
