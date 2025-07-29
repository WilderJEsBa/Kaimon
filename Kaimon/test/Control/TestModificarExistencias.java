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
public class TestModificarExistencias {

    private static ModificarExistencias modificarExistencias = new ModificarExistencias();
    private String LA_CANTIDAD_ES_INCORRECTA = "La cantidad es incorrecta";
    private String TODO_CORRECTO = "Modificacion exitosa";

    public TestModificarExistencias() {
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
    public void TestCantidadIncorrecta() {
        Producto p = new Producto();
        p.setNombreProducto("Hamb pionera");
        p.setCantidad(20);
        assertEquals(modificarExistencias.validarmodificarExistencias(p, -184), LA_CANTIDAD_ES_INCORRECTA);
    }

    @Test
    public void TestTodoCorrecto() {
        Producto p = new Producto();
        p.setNombreProducto("Hamb pionera");
        p.setCantidad(20);
        assertEquals(modificarExistencias.validarmodificarExistencias(p, 157), TODO_CORRECTO);

    }

}
