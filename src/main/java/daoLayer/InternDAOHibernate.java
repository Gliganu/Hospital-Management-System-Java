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

@Component("internDAO")
@Repository
@Transactional
public class InternDAOHibernate implements InternDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateIntern(Intern intern){
		session().saveOrUpdate(intern);
	}

	@Override
	public void deleteIntern(int id){
		Criteria crit= session().createCriteria(Intern.class);
		crit.add(Restrictions.idEq(id));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Intern> getAllInterns(){
		List<Intern> internList =  session().createQuery("from Intern").list();
		return internList;
	}

	@Override
	public Intern getInternById(int id){
		Criteria crit= session().createCriteria(Intern.class);
		crit.add(Restrictions.idEq(id));
		return (Intern) crit.uniqueResult();
	}

	@Override
	public boolean exists(int id) {

		Criteria crit= session().createCriteria(Intern.class);
		crit.add(Restrictions.idEq(id));
		return ((Intern) crit.uniqueResult()) != null;
		
	}



}
