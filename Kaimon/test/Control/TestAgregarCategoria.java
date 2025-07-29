/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Categoria;
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
public class TestAgregarCategoria {

    private static AgregarCategoria agregarCategoria = new AgregarCategoria();
    private String LONG_NOMBRE_INCORRECTA = "La longitud del nombre es incorrecta";
    private String CATEGORIA_REPETIDA = "La categoria ya existe";

    public TestAgregarCategoria() {
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
    public void TestNombreCategoria() {
        Categoria u = new Categoria();
        u.setNombreCategoria("Ham");
        assertEquals(agregarCategoria.validarAgregarCategoria(u), LONG_NOMBRE_INCORRECTA);
        
    }
    @Test
    public void TestCategoriaRepetida(){
        Categoria u = new Categoria(); 
        u.setNombreCategoria("Hamburguesa 100g");
        assertEquals(agregarCategoria.validarAgregarCategoria(u), CATEGORIA_REPETIDA );
        u.setNombreCategoria("Perro caliente");
        assertEquals(agregarCategoria.validarAgregarCategoria(u), CATEGORIA_REPETIDA );
        
    }

   
}
