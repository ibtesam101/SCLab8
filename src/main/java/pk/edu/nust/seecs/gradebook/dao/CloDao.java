package pk.edu.nust.seecs.gradebook.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.util.HibernateUtil;

/**
 * Data Access Object for Clo Entity. 
 * <p>
 Wrapper Class for CRUD operations on Clo.
 */
public class CloDao {

    public void addClo(Clo clo) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(clo);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteClo(int cloid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Clo clo = (Clo) session.load(Clo.class, new Integer(cloid));
            session.delete(clo);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateClo(Clo clo) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(clo);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Clo> getAllClos() {
        List<Clo> clos = new ArrayList<Clo>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            clos = session.createQuery("from Clo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return clos;
    }

    public Clo getCloById(int cloid) {
        Clo clo = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            /*trns = session.beginTransaction();
            String queryString = "from Clo where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", cloid);
            clo = (Clo) query.uniqueResult();*/
        	
        	Criteria cr = session.createCriteria(Clo.class);
        	
        	cr.add(Restrictions.eq("cloId", cloid));
        	
        	List result= cr.list();
        	
        	clo = (Clo) result.get(0);
        	
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return clo;
    }
}