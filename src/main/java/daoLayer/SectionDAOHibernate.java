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

import domainLayer.Section;

@Component("sectionDAO")
@Repository
@Transactional
public class SectionDAOHibernate implements SectionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateSection(Section section){
		session().saveOrUpdate(section);
	}

	@Override
	public void deleteSection(String name){
		Criteria crit= session().createCriteria(Section.class);
		crit.add(Restrictions.idEq(name));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Section> getAllSections(){
		List<Section> sectionList =  session().createQuery("from Section").list();
		return sectionList;
	}

	@Override
	public Section getSectionbyName(String name){
		Criteria crit= session().createCriteria(Section.class);
		crit.add(Restrictions.idEq(name));
		return (Section) crit.uniqueResult();
	}

	@Override
	public boolean exists(String name) {

		Criteria crit= session().createCriteria(Section.class);
		crit.add(Restrictions.idEq(name));
		return ((Section) crit.uniqueResult()) != null;
		
	}



}
