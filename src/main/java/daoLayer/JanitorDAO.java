package daoLayer;

import java.util.List;

import domainLayer.Intern;
import domainLayer.Janitor;

public interface JanitorDAO {

	public void addOrUpdateJanitor(Janitor janitor);
	
	public void deleteJanitor(int id);

	public List<Janitor> getAllJanitors();
	
	public Janitor getJanitorById(int id);
	
	public boolean exists(int id);
	
}
