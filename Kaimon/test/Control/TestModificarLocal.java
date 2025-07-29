/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Local;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TestModificarLocal {
        private static ModificarLocal modificarLocal = new ModificarLocal();
        private String LONG_RAZON_SOCIAL_INCORRECTA="La longitud de la razon social es incorrecta";
        private String LONG_DIRECCION_INCORRECTA="La longitud de la direccion es incorrecta";
        private String LONG_CONTACTO_INCORRECTA="La longitud del contacto es incorrecta";
        private String LONG_ADMINISTRADOR_INCORRECTA="La longitud del nombre del administrador es incorrecta";
        private String LONG_CONTRASEÑA_INCORRECTA="La longitud de la contraseña es incorrecta";
        private String DATOS_VALIDOS="Modificacion exitosa";
        
    public TestModificarLocal() {

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
    public void TestRazonSocial(){
        Local u = new Local();
        u.setRazonSocial("NBA");
        assertEquals(modificarLocal.validarModificarLocal(u), LONG_RAZON_SOCIAL_INCORRECTA);
    }
    
    @Test 
    public void TestDireccion(){
        Local u = new Local();
        u.setDirecccion("NA");
        assertEquals(modificarLocal.validarModificarLocal(u),LONG_DIRECCION_INCORRECTA );
     
    }
    
    @Test
    public void TestContacto(){
        Local u = new Local();
        u.setContacto("NA");
        assertEquals(modificarLocal.validarModificarLocal(u),LONG_CONTACTO_INCORRECTA );
    }
    
    @Test 
    public void TestAdministrador(){
        Local u = new Local();
        u.setNombreAdministrador("NA");
        assertEquals(modificarLocal.validarModificarLocal(u),LONG_ADMINISTRADOR_INCORRECTA );
        
    }
    
    @Test 
    public void TestContraseña(){
        Local u = new Local();
        u.setContacto("123");
        assertEquals(modificarLocal.validarModificarLocal(u),LONG_CONTRASEÑA_INCORRECTA);
    }
}
