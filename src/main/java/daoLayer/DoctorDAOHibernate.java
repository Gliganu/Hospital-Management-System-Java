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

import domainLayer.Doctor;
import domainLayer.Intern;

@Component("doctorDAO")
@Repository
@Transactional
public class DoctorDAOHibernate implements DoctorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateDoctor(Doctor doctor){
		session().saveOrUpdate(doctor);
	}

	@Override
	public void deleteDoctor(int id){
		Criteria crit= session().createCriteria(Doctor.class);
		crit.add(Restrictions.idEq(id));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctorList =  session().createQuery("from Doctor").list();
		return doctorList;
	}

	@Override
	public Doctor getDoctorById(int id){
		Criteria crit= session().createCriteria(Doctor.class);
		crit.add(Restrictions.idEq(id));
		return (Doctor) crit.uniqueResult();
	}

	@Override
	public boolean exists(int id) {
		Criteria crit= session().createCriteria(Doctor.class);
		crit.add(Restrictions.idEq(id));
		return ((Doctor) crit.uniqueResult()) != null;
	}

	@Override
	public Doctor getDoctorByName(String name) {
		Criteria crit= session().createCriteria(Doctor.class);
		crit.add(Restrictions.eq("name",name));
		return (Doctor) crit.uniqueResult();
	}



}
