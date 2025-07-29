/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Local;
import Entidad.Producto;
import Entidad.Producto_;
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
public class TestAgregarProducto {
    
    private static AgregarProducto agregarProducto = new AgregarProducto();
    private String LONG_NOMBRE_INCORRECTA = "La longitud del nombre es incorrecta";
    private String PRODUCTO_YA_EXISTE = "El producto ya existe";
    private String LA_LONGITUD_DE_LA_DESCRIPCION_INCORRECTA = "La longitud de la descripción es incorrecta";
    private String PRECIO_INCORRECTO = "El precio es incorrecto";
    private String TODO_CORRECTO = "Producto añadido con exito";
    
    public TestAgregarProducto() {
        
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
    public void TestNombreProducto() {
        Producto u = new Producto();
        u.setNombreProducto("la");
        assertEquals(agregarProducto.validarAgregarProducto(u), LONG_NOMBRE_INCORRECTA);
        
    }

    @Test
    public void TestVerificarLongitudDescripcion() {
        Producto u = new Producto();
        u.setNombreProducto("Hamb pioa");
        u.setDescripcion("asd");
        assertEquals(agregarProducto.validarAgregarProducto(u), LA_LONGITUD_DE_LA_DESCRIPCION_INCORRECTA);
    }    
    
    @Test
    public void TestProductoRepetido() {
        Producto u = new Producto();
        u.setDescripcion("aascsd");
        u.setNombreProducto("Hamb pionera");
        assertEquals(agregarProducto.validarAgregarProducto(u), PRODUCTO_YA_EXISTE) ;   
    }
    @Test
    public void TestVerificarPrecio(){
        Producto u = new Producto();
        u.setNombreProducto("Hamb pioa");
        u.setDescripcion("asdasd");
        u.setPrecio(-666);
        assertEquals(agregarProducto.validarAgregarProducto(u),PRECIO_INCORRECTO );       
    }
    
    @Test
    public void TestTodoCorrecto(){
        Producto u  = new Producto();
        u.setNombreProducto("Perro caliente");
        u.setDescripcion("asdasd");
        u.setPrecio(1000);
        assertEquals(agregarProducto.validarAgregarProducto(u), TODO_CORRECTO ); 
        
    }

}

// TODO add test methods here.
// The methods must be annotated with annotation @TestAgregarProducto. For example:
//
// @TestAgregarProducto
// public void hello() {}

