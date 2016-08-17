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

import domainLayer.Intern;
import domainLayer.Janitor;

@Component("janitorDAO")
@Repository
@Transactional
public class JanitorDAOHibernate implements JanitorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateJanitor(Janitor janitor){
		session().saveOrUpdate(janitor);
	}

	@Override
	public void deleteJanitor(int id){
		Criteria crit= session().createCriteria(Janitor.class);
		crit.add(Restrictions.idEq(id));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Janitor> getAllJanitors(){
		List<Janitor> janitorList =  session().createQuery("from Janitor").list();
		return janitorList;
	}

	@Override
	public Janitor getJanitorById(int id){
		Criteria crit= session().createCriteria(Janitor.class);
		crit.add(Restrictions.idEq(id));
		return (Janitor) crit.uniqueResult();
	}

	@Override
	public boolean exists(int id) {

		Criteria crit= session().createCriteria(Janitor.class);
		crit.add(Restrictions.idEq(id));
		return ((Janitor) crit.uniqueResult()) != null;
		
	}



}
