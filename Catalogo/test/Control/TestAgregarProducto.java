/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Producto;
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
    private String LA_LONGITUD_DE_LA_DESCRIPCION_INCORRECTA = "la Longitud de la descripcion incorrecta";
    private String PRECIO_INCORRECTO = "El precio es incorrecto";

    public TestAgregarProducto() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto a = new Producto();
        Producto b = new Producto();
        Producto c = new Producto();

        a.setNombreProducto("Hamburguesa Pionera");
        a.setNombreProducto("Perro Pionero");

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
    public void TestProductoRepetido() {
        Producto u = new Producto();
        u.setNombreProducto("Hamburguesa Pionera");
        assertEquals(agregarProducto.validarAgregarProducto(u), PRODUCTO_YA_EXISTE);

    }

    @Test
    public void TestLongDesInconrrecta() {
        Producto u = new Producto();
        u.setDescripcion("des");
        assertEquals(agregarProducto.validarAgregarProducto(u), LONG_NOMBRE_INCORRECTA);
    }

    @Test
    public void TestPrecioIncorrecto() {
        Producto u = new Producto();
        u.setPrecio(-7879);
        assertEquals(agregarProducto.validarAgregarProducto(u), PRECIO_INCORRECTO);

        
    }

}

// TODO add test methods here.
// The methods must be annotated with annotation @TestAgregarProducto. For example:
//
// @TestAgregarProducto
// public void hello() {}

