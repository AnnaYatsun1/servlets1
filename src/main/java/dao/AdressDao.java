package dao;


import models.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class AdressDao {
    public void save(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(address);
        tx1.commit();
        session.close();
    }

    public void update(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(address);
        tx1.commit();
        session.close();
    }

    public void delete(Address address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(address);
        tx1.commit();
        session.close();
    }
}
