/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CategoriaDAO;

import DAO.LocalDAO;
import DAO.ProductoDAO;
import Entidad.Categoria;
import Entidad.Local;
import Entidad.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class Inicializacion {
    
    public Inicializacion() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void initData(){
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        LocalDAO localDAO = new LocalDAO();
        
        Local local = new Local();
        local.setRazonSocial("Cocheros");
        local.setDirecccion("Carrera 33 No23-51");
        local.setContacto("Pagina web: www.cocheros.com.co, Instagram: CocherosCol");
        local.setNombreAdministrador("admin");
        local.setContraseña("admin");
        localDAO.crear(local);
        
        Categoria ac = new Categoria();
        Categoria bc = new Categoria();
        ac.setNombreCategoria("Hamburguesa 100g");
        bc.setNombreCategoria("Perro caliente");
        categoriaDAO.crear(ac);
        categoriaDAO.crear(bc);
        
        Producto ap = new Producto();
        Producto bp = new Producto();
        Producto cp = new Producto();
        Producto dp = new Producto();
        ap.setNombreProducto("Hamb pionera");
        ap.setDescripcion("Res o pollo, queso, papa, vegetales y salsas");
        ap.setPrecio(7500);
        ap.setCantidad(20);
        ap.setCategoria(ac);
        bp.setNombreProducto("Hamb valiente");
        bp.setDescripcion("Ingredientes base mas tocineta o jamon");
        bp.setPrecio(9300);
        bp.setCantidad(35);
        bp.setCategoria(ac);
        cp.setNombreProducto("Perro pionero");
        cp.setDescripcion("Queso, papa cabello de angel y salsas");
        cp.setPrecio(7000);
        cp.setCantidad(27);
        cp.setCategoria(bc);
        dp.setNombreProducto("Perro valiente");
        dp.setDescripcion("Ingredientes base mas tocineta o jamon");
        dp.setPrecio(8800);
        dp.setCantidad(23);
        dp.setCategoria(bc);
        productoDAO.crear(ap);
        productoDAO.crear(bp);
        productoDAO.crear(cp);
        productoDAO.crear(dp);

    }
}
