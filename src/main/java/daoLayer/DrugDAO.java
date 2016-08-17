package daoLayer;

import java.util.List;

import domainLayer.Drug;

public interface DrugDAO {

	public void addOrUpdateDrug(Drug drug);
	
	public void deleteDrug(String name);

	public List<Drug> getAllDrugs();
	
	public Drug getDrugByName(String name);
	
	public boolean exists(String name);
	
}
