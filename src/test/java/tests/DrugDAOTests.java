package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daoLayer.DrugDAO;
import domainLayer.Drug;
import domainLayer.Intern;
import domainLayer.Section;

@ContextConfiguration(locations = {
		"classpath:config/dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)


public class DrugDAOTests {

	
	@Autowired
	private DrugDAO drugDAO ;

	@Autowired
	private DataSource dataSource;
	 
	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from drug");
	}

	private Drug drug1 = new Drug("Algocalmin", "potasiu,calciu", null);
	private Drug drug2 = new Drug("Paracetamol", "fier,zinc,calciu", null);
	private Drug drug3 = new Drug("Nurofen", "B12,B7,magneziu", null);
	
	@Test
	public void testCreate() {
		drugDAO.addOrUpdateDrug(drug1);
		drugDAO.addOrUpdateDrug(drug2);
		drugDAO.addOrUpdateDrug(drug3);

		List<Drug> drugList = drugDAO.getAllDrugs();
		assertEquals("Three users should have been created and retrieved", 3,
				drugList.size());
	}
	
	//@Test 
	public void testRetrieve(){
		drugDAO.addOrUpdateDrug(drug1);
		assertTrue(drugDAO.exists(drug1.getName()));
		assertTrue(drugDAO.getDrugByName(drug1.getName()).equals(drug1));
	}
	
	//@Test 
	public void testDelete(){
		drugDAO.addOrUpdateDrug(drug1);
		drugDAO.addOrUpdateDrug(drug2);
		
		drugDAO.deleteDrug(drug1.getName());
		drugDAO.deleteDrug(drug2.getName());
		
		List<Drug> drugList = drugDAO.getAllDrugs();
		assertEquals("Three shouldn't be any users in the db", 0,
				drugList.size());
	}
	
	

}