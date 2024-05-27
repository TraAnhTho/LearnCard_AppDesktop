package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.User;

public class u_Dao {
//    private static final SessionFactory sessionFactory = builSessionFactory();
//
//    private static SessionFactory builSessionFactory() {
//        try {
//            // Tạo SessionFactory từ hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory();
//        } catch (HibernateException ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public List<User> getAllUser() {
//        try (Session session = sessionFactory.openSession()) {
//            // No need for explicit transaction for read operations
//            // Retrieve list of clients
//            return session.createQuery("from User", User.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Return empty list or handle the exception as needed
//            return null;
//        }
//    }
}
