/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wilde
 */
public class LocalDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoPU");
    
    public void crear(Local local) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(local);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction();
        } finally {
            em.close();
        }
    }
    
    public Local leer() {
        EntityManager em = emf.createEntityManager();
        Local local = null;
        Query q = em.createQuery(" SELECT u FROM Local u ");
        try {
            local = (Local) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            local = (Local) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return local;
        }
    }
    
    public Local leer(Local par) {
        EntityManager em = emf.createEntityManager();
        Local local = null;
        System.out.println(par.getContraseña());
        Query q = em.createQuery(" SELECT u FROM Local u " + 
                " WHERE u.nombreAdministrador LIKE :nombreAdministrador " + 
                " AND u.contraseña LIKE :contraseña ")
                .setParameter("nombreAdministrador", par.getNombreAdministrador())
                .setParameter("contraseña", par.getContraseña());
        try {
            local = (Local) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            local = (Local) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return local;
        }
    }
    
    public boolean actualizar(Local nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Local object;
        boolean ret = false;
        try {
            object = leer();
            object.setRazonSocial(nuevoObjeto.getRazonSocial());
            object.setDirecccion(nuevoObjeto.getDirecccion());
            object.setContacto(nuevoObjeto.getContacto());
            object.setNombreAdministrador(nuevoObjeto.getNombreAdministrador());
            object.setContraseña(nuevoObjeto.getContraseña());
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
