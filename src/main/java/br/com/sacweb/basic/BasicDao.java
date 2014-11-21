/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sacweb.basic;

import br.com.sacweb.model.Log;
import br.com.sacweb.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JM
 */
public class BasicDao<T> implements Serializable {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Object save(Class entityClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Long cityId = null;
        try {
            transaction = session.beginTransaction();
            session.save(entityClass);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            Log log = new Log();
            log.setLogDescricao(e.getMessage() + '\n' + e.getStackTrace().toString());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entityClass;
    }

    public Object update(Class entityClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Long cityId = null;
        try {
            transaction = session.beginTransaction();
            session.merge(entityClass);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            Log log = new Log();
            log.setLogDescricao(e.getMessage() + '\n' + e.getStackTrace().toString());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entityClass;
    }

    public List<T> list(Class entityClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Long cityId = null;
        try {
            transaction = session.beginTransaction();

            transaction.commit();
            return session.createCriteria(entityClass).list();
        } catch (HibernateException e) {
            transaction.rollback();
            Log log = new Log();
            log.setLogDescricao(e.getMessage() + '\n' + e.getStackTrace().toString());
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public List<T> listById(String namedQuery,String field, int id, Class entityClass){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            transaction.commit();
            return session.getNamedQuery(namedQuery).setParameter(field, id).list();
        } catch (HibernateException e) {
            transaction.rollback();
            Log log = new Log();
            log.setLogDescricao(e.getMessage() + '\n' + e.getStackTrace().toString());
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
