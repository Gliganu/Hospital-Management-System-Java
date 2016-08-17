package daoLayer;

import java.util.List;

import domainLayer.Patient;

public interface PatientDAO {

	public void addOrUpdatePatient(Patient patient);
	
	public void deletePatient(int id);

	public List<Patient> getAllPatients();
	
	public Patient getPatientById(int id);
	
	public boolean exists(int id);
	
}
