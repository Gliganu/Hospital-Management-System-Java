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

import domainLayer.Drug;
import domainLayer.Section;

@Component("drugDAO")
@Repository
@Transactional
public class DrugDAOHibernate implements DrugDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateDrug(Drug drug){
		session().saveOrUpdate(drug);
	}

	@Override
	public void deleteDrug(String name){
		Criteria crit= session().createCriteria(Section.class);
		crit.add(Restrictions.idEq(name));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Drug> getAllDrugs(){
		List<Drug> drugList =  session().createQuery("from Drug").list();
		return drugList;
	}

	@Override
	public Drug getDrugByName(String name ){
		Criteria crit= session().createCriteria(Drug.class);
		crit.add(Restrictions.idEq(name));
		return (Drug) crit.uniqueResult();
	}

	@Override
	public boolean exists(String name) {

		Criteria crit= session().createCriteria(Drug.class);
		crit.add(Restrictions.idEq(name));
		return ((Drug) crit.uniqueResult()) != null;
		
	}



}
