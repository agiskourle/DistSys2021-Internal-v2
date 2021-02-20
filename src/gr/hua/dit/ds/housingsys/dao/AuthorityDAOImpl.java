package gr.hua.dit.ds.housingsys.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.housingsys.entity.Authority;
import gr.hua.dit.ds.housingsys.entity.User;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int addAuthority(String username, String authority) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Authority authorityfordb = new Authority(username, authority);
			currentSession.save(authorityfordb);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int deleteAuthority(String username_old) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Authority> query = currentSession.createQuery("select a from Authority a " + "where a.username=:username_old",
					Authority.class);
			query.setParameter("username_old", username_old);
			Authority authority_obj = query.getSingleResult();
			currentSession.delete(authority_obj);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
