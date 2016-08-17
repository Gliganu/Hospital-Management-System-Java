package daoLayer;

import java.util.List;

import domainLayer.Disease;
import domainLayer.Drug;

public interface DiseaseDAO {

	public void addOrUpdateDisease(Disease disease);
	
	public void deleteDisease(String name);

	public List<Disease> getAllDiseases();
	
	public Disease getDiseaseByName(String name);
	
	public boolean exists(String name);
	
	
}
