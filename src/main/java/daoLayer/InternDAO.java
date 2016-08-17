package daoLayer;

import java.util.List;

import domainLayer.Intern;
import domainLayer.User;

public interface InternDAO {

	public void addOrUpdateIntern(Intern intern);
	
	public void deleteIntern(int id);

	public List<Intern> getAllInterns();
	
	public Intern getInternById(int id);
	
	public boolean exists(int id);
	
}
