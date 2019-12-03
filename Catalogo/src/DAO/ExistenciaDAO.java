/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Existencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wilde
 */
public class ExistenciaDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoPU");
    
    public void crear(Existencia existencia) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(existencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction();
        } finally {
            em.close();
        }
    }
    
    public Existencia leer(Existencia par) {
        EntityManager em = emf.createEntityManager();
        Existencia existencia = null;
        Query q = em.createQuery(" SELECT u FROM Existencia u " + 
                " WHERE u.codigoExistencia LIKE :codigoExistencia ")
                .setParameter("codigoExistencia", par.getCodigoExistencia());
        try {
            existencia = (Existencia) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            existencia = (Existencia) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return existencia;
        }
    }
    
    public boolean actualizar(Existencia object, Existencia nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setCantidad(nuevoObjeto.getCantidad());
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
