/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Local;
import static Entidad.Local_.nombreAdministrador;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class TestValidarLogin {
    
    private static ValidarLogin validarLogin = new  ValidarLogin();
    private String LONG_NOMBRE_INCORRECTA= "La longitud del nombre del administrador es incorrecta";
    private String LONG_PASSWORD_INCORRECTA= "La longitud de la contraseña es incorrecta";
    private String USUARIO_AUTORIZADO ="Ingreso exitoso";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    
    public TestValidarLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
     @Test
      public void testLongitudNombre(){
        Local u = new Local();
        u.setNombreAdministrador("asd");
        u.setContraseña("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
      }
    @Test
    public  void testLongitudContraseña(){
        Local u = new Local();
        u.setNombreAdministrador("administrador");
        u.setContraseña("12");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
                         
    }
    @Test
    public void testNombre(){
        Local u = new Local();
        u.setNombreAdministrador("Admin");
        u.setContraseña("12345");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);
        
    }
    @Test
    public void testContraseña(){
        Local u = new Local();
        u.setNombreAdministrador("ADMIN");
        u.setContraseña("1234");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);            
    } 
 
    
   
        
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

