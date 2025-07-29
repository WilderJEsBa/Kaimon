
package DAO;

import Entidad.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class PedidoDAO {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoPU");
    
    public void crear(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction();
        } finally {
            em.close();
        }
    }
    
    public Pedido leer(Pedido par) {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = null;
        Query q = em.createQuery(" SELECT p FROM Pedido p " + 
                " WHERE p.codigoPedido = :codigoPedido ")
                .setParameter("codigoPedido", par.getCodigoPedido());
        try {
            pedido = (Pedido) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            pedido = (Pedido) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return pedido;
        }
    }
    
    public boolean actualizar(Pedido object, Pedido nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.getPrecioTotal();
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
