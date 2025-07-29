/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmendezp
 */
public class TestModificarProducto {
    private static ModificarProducto modificarProducto = new ModificarProducto();
    private String LA_LONGITUD_DE_NUEVA_DESCRIPCION_INCORRECTA = "La longitud de la nueva descripción es incorrecta";
    private String NUEVO_PRECIO_INCORRECTO = "El nuevo precio es incorrecto";
    
    public TestModificarProducto() {
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
    public void TestLongitudIncorrecta(){
        Producto u = new Producto();
        Producto nuevo = new Producto();
        u.setDescripcion("Res o pollo, queso, papa, vegetales y salsas");
        nuevo.setDescripcion("anti");
        assertEquals(modificarProducto.validarModificarProducto(u, nuevo), LA_LONGITUD_DE_NUEVA_DESCRIPCION_INCORRECTA);
      
    }
    @Test
    public void TestPrecioIncorrecto(){
        Producto u = new Producto();
        Producto nuevo = new Producto();
        u.setDescripcion("Res o pollo, queso, papa, vegetales y salsas");
        u.setPrecio(7500);
        nuevo.setPrecio(0);
        assertEquals(modificarProducto.validarModificarProducto(u, nuevo), NUEVO_PRECIO_INCORRECTO);
        
    }
         
    
}
