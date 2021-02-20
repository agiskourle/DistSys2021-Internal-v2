package gr.hua.dit.ds.housingsys.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.housingsys.entity.Student;
import gr.hua.dit.ds.housingsys.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int addUser(String username, String password) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			User user = new User(username, password, 1);
			currentSession.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int deleteUser(String username_old) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<User> query = currentSession.createQuery("select u from User u " + "where u.username=:username_old",
					User.class);
			query.setParameter("username_old", username_old);
			User user_obj = query.getSingleResult();
			currentSession.delete(user_obj);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public User getUser(String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("select u from User u " + "where u.password=:password",
				User.class);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		return user;
	}

}
