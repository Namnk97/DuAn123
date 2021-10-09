package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManager em;
	private static EntityManagerFactory factory;

	public JpaUtil() {
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("Duan123");
		}
		return factory;
	}

	public static EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			getEntityManagerFactory();
			em = factory.createEntityManager();
		}
		return em;
	}
}
