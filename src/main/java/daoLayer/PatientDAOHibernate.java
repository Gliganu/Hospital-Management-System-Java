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
import domainLayer.Patient;

@Component("patientDAO")
@Repository
@Transactional
public class PatientDAOHibernate implements PatientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdatePatient(Patient patient){
		session().saveOrUpdate(patient);
	}

	@Override
	public void deletePatient(int id){
		Criteria crit= session().createCriteria(Patient.class);
		crit.add(Restrictions.idEq(id));
		session().delete((Patient)crit.uniqueResult());
	}

	@Override
	public List<Patient> getAllPatients(){
		List<Patient> patientList =  session().createQuery("from Patient").list();
		return patientList;
	}

	@Override
	public Patient getPatientById(int id){
		Criteria crit= session().createCriteria(Patient.class);
		crit.add(Restrictions.idEq(id));
		return (Patient) crit.uniqueResult();
	}

	@Override
	public boolean exists(int id) {

		Criteria crit= session().createCriteria(Patient.class);
		crit.add(Restrictions.idEq(id));
		return ((Patient) crit.uniqueResult()) != null;
	}

}
