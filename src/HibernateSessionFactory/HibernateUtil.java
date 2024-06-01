package HibernateSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private final static SessionFactory sessionFactory = builSessionFactory();

	private static SessionFactory builSessionFactory() {
		try {
			// Tạo SessionFactory từ hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
