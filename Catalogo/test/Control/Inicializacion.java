/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CategoriaDAO;
import DAO.ExistenciaDAO;
import DAO.LocalDAO;
import DAO.ProductoDAO;
import Entidad.Categoria;
import Entidad.Existencia;
import Entidad.Local;
import Entidad.Producto;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        LocalDAO localDAO = new LocalDAO();
        
        Local local = new Local();
        local.setRazonSocial("Cocheros");
        local.setDirecccion("Carrera 33 No23-51");
        local.setContacto("Pagina web: www.cocheros.com.co, Instagram: CocherosCol");
        local.setNombreAdministrador("Hector Alvarez");
        local.setContraseña("administrador");
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
        ap.setCategoria(ac);
        bp.setNombreProducto("Hamb valiente");
        bp.setDescripcion("Ingredientes base mas tocineta o jamon");
        bp.setPrecio(9300);
        bp.setCategoria(ac);
        cp.setNombreProducto("Perro pionero");
        cp.setDescripcion("Queso, papa cabello de angel y salsas");
        cp.setPrecio(7000);
        cp.setCategoria(bc);
        dp.setNombreProducto("Perro valiente");
        dp.setDescripcion("Ingredientes base mas tocineta o jamon");
        dp.setPrecio(8800);
        dp.setCategoria(bc);
        productoDAO.crear(ap);
        productoDAO.crear(bp);
        productoDAO.crear(cp);
        productoDAO.crear(dp);
        
        Existencia ae = new Existencia();
        Existencia be = new Existencia();
        Existencia ce = new Existencia();
        Existencia de = new Existencia();
        ae.setCantidad(20);
        ae.setFecha(new Date());
        ae.setProducto(ap);
        be.setCantidad(35);
        be.setFecha(new Date());
        be.setProducto(bp);
        ce.setCantidad(27);
        ce.setFecha(new Date());
        ce.setProducto(cp);
        de.setCantidad(23);
        de.setFecha(new Date());
        de.setProducto(dp);
        existenciaDAO.crear(ae);
        existenciaDAO.crear(be);
        existenciaDAO.crear(ce);
        existenciaDAO.crear(de);
    }
}
