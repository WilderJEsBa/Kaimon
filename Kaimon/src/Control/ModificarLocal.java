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
public class ModificarLocal {
    
    private LocalDAO dao = new LocalDAO();
    
    public String validarModificarLocal(Local nuevo){
        if (!verificarLongitudRazonSocial(nuevo.getRazonSocial())) {
            return ("La longitud de la razon social es incorrecta");
        }
        if (!verificarLongitudDireccion(nuevo.getDirecccion())) {
            return ("La longitud de la direccion es incorrecta");
        }
        if (!verificarLongitudContacto(nuevo.getContacto())) {
            return ("La longitud del contacto es incorrecta");
        }
        if (!verificarLongitudNombreAdministrador(nuevo.getNombreAdministrador())) {
            return ("La longitud del nombre del administrador es incorrecta");
        }
        if (!verificarLongitudContrasenia(nuevo.getContraseña())) {
            return ("La longitud de la contraseña es incorrecta");
        }
        dao.actualizar(nuevo);
        return ("Modificacion exitosa");
    }
    
    private boolean verificarLongitudRazonSocial(String razonSocial){
        return (razonSocial.length() >= 4 && razonSocial.length() <= 50);
    }
    
    private boolean verificarLongitudDireccion(String direccion){
        return (direccion.length() >= 4 && direccion.length() <= 50);
    }
    
    private boolean verificarLongitudContacto(String contacto){
        return (contacto.length() >= 4 && contacto.length() <= 50);
    }
    
    private boolean verificarLongitudContrasenia(String contraseña){
        return (contraseña.length() >= 4 && contraseña.length() <= 50);
    }
    
    private boolean verificarLongitudNombreAdministrador(String nombreAdministrador){
        return (nombreAdministrador.length() >= 4 && nombreAdministrador.length() <= 50);
    }
}
