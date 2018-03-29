package dao;

import models.MusicType;
import models.MusicTypes;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MusicTypesDao {
    public MusicTypes findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MusicTypes.class, id);
    }

    public MusicTypes findByName(String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MusicTypes.class, name);
    }

    public void save(MusicTypes musicTypes) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(musicTypes);
        tx1.commit();
        session.close();
    }

    public void update(MusicTypes musicTypes) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(musicTypes);
        tx1.commit();
        session.close();
    }

    public void delete(MusicTypes musicTypes) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(musicTypes);
        tx1.commit();
        session.close();
    }

    public List<MusicTypes> findAll() {
        List<MusicTypes> musicTypes = (List<MusicTypes>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From MusicTypes").list();
        return musicTypes;
    }

}
