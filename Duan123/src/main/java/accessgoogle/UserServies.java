package accessgoogle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtil;

public class UserServies {
	private EntityManager em;

	public UserServies() {
		this.em = JpaUtil.getEntityManager();
	}

	public User findByEmail(String Gmail) {
		String hql = "Select u FROM User u WHERE u.gmail = :gmail";
		TypedQuery<User> query = em.createQuery(hql, User.class);
		query.setParameter("gmail", Gmail);
		List<User> listUser = query.getResultList();
		for (User us : listUser) {
			return us;
		}
		return null;
	}
}
