/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Categoria;
import Entidad.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mauricio
 */
public class ProductoDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoDB_PU");
    CategoriaDAO dao = new CategoriaDAO();
    
    public void crear(Producto producto, Categoria categoria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(producto);
            dao.actualizar(categoria, producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Producto leer(Producto par) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;
        Query q = em.createQuery("SELECT u FROM Producto u "
                + " WHERE u.nombre LIKE :nombre ")
                .setParameter("nombre", par.getNombreProducto());
        try {
            producto = (Producto) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }
    }

    public List<Producto> leer(String string) {
        EntityManager em = emf.createEntityManager();
        List<Producto> productos = null;
        Query q = em.createQuery("SELECT u FROM Producto u "
                + " WHERE u.nombre LIKE %:string% ")
                .setParameter("string", string);
        try {
            productos = (List<Producto>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return productos;
        }
    }

    public boolean actualizar(Producto object, Producto nuevoObjecto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setDescripcion(nuevoObjecto.getNombreProducto());
            object.setPrecio(nuevoObjecto.getPrecio());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
}
