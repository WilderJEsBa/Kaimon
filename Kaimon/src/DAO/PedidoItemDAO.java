/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.PedidoItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wilde
 */
public class PedidoItemDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoPU");
    
    public void crear(PedidoItem item) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction();
        } finally {
            em.close();
        }
    }
    
    public PedidoItem leer(PedidoItem par) {
        EntityManager em = emf.createEntityManager();
        PedidoItem item = null;
        Query q = em.createQuery(" SELECT p FROM PedidoItem p " + 
                " WHERE p.codigoItem = :codigoItem ")
                .setParameter("codigoItem", par.getCodigoItem());
        try {
            item = (PedidoItem) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            item = (PedidoItem) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return item;
        }
    }
    
}
