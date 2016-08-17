package daoLayer;

import java.util.List;

import domainLayer.Doctor;

public interface DoctorDAO {

	public void addOrUpdateDoctor(Doctor doctor);
	
	public void deleteDoctor(int id);

	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorById(int id);
	
	public Doctor getDoctorByName(String name);
	
	public boolean exists(int id);
}
