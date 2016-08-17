package daoLayer;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domainLayer.User;

@Component("userDAO")
@Repository
@Transactional
public class UserDAOHibernate implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateUser(User user) {
		session().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(String username) {
		Criteria crit= session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList =  session().createQuery("from User").list();
		return userList;
	}

	@Override
	public User getUserByUsername(String username) {
		Criteria crit= session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		return (User) crit.uniqueResult();
	}

	@Override
	public boolean exists(String username) {

		Criteria crit= session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		return ((User) crit.uniqueResult()) != null;
	}

	@Override
	public void changePassword(String username, String password) {
		Criteria crit= session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		User currentUser=(User) crit.uniqueResult();
		currentUser.setPassword(password);
		session().update(currentUser);
		
	}

}
