package dao;

import models.Auto;
import models.MusicTypes;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }


    public boolean isCredentional(String login, String password) {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        boolean exist = false;
        for (User user : users) {
            if (user.getName().equals(login) && user.getPassword().equals(password)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }
    public MusicTypes findMusicTypeById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MusicTypes.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

}