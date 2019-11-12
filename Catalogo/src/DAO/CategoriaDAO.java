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
 * @author westradab
 */
public class CategoriaDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoDB_PU");

    public void crear(Categoria object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Categoria leer(Categoria par) {
        EntityManager em = emf.createEntityManager();
        Categoria categoria = null;
        Query q = em.createQuery("SELECT u FROM Categoria u "
                + " WHERE u.nombre LIKE :nombre ")
                .setParameter("nombre", par.getNombreCategoria());
        try {
            categoria = (Categoria) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            categoria = (Categoria) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return categoria;
        }
    }
    
    public List<Categoria> leer() {
        EntityManager em = emf.createEntityManager();
        List<Categoria> categoria = null;
        Query q = em.createQuery("SELECT u FROM Categoria u ");
        try {
            categoria = (List<Categoria>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return categoria;
        }
    }
    
    public boolean actualizar(Categoria objeto, Producto nuevo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            objeto = leer(objeto);
            objeto.getProductos().add(nuevo);
            em.merge(objeto);
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
