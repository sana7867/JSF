/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Util.HibernateUtil;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tecra
 */

public abstract class AbstractFacad<T> implements IDao<T> {

    @Override
    public boolean create(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public T getById(int id) {
        T entity = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        entity = (T) session.get(getEntityClass(), id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> getAll() {
        List<T> entities = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        entities = session.createQuery("from " + getEntityClassName()).list();
        session.getTransaction().commit();
        return entities;
    }

    // Les classes concrètes devront implémenter cette méthode pour fournir la classe d'entité spécifique
    protected abstract Class<T> getEntityClass();

    // Utilisez cette méthode pour obtenir le nom de la classe d'entité (pour la requête HQL)
    private String getEntityClassName() {
        return getEntityClass().getSimpleName();
    }
}
