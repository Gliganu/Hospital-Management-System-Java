package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daoLayer.DiseaseDAO;
import daoLayer.DrugDAO;
import domainLayer.Disease;
import domainLayer.Drug;
import domainLayer.SeverityType;

@ContextConfiguration(locations = { "classpath:config/dao-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DiseaseDAOTests {

	@Autowired
	private DrugDAO drugDAO;
	@Autowired
	private DiseaseDAO diseaseDAO;
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from disease_drug");
		jdbcTemplate.execute("delete from disease");
		jdbcTemplate.execute("delete from drug");
		// jdbcTemplate.execute("delete from drug");
		addDrugs();
		addDiseases();
	}

	private Drug drug1;
	private Drug drug2;
	private Drug drug3;

	private Disease disease1;
	private Disease disease2;

	@Test
	public void testCreate() {
		diseaseDAO.addOrUpdateDisease(disease1);
		diseaseDAO.addOrUpdateDisease(disease2);

		List<Disease> diseaseList = diseaseDAO.getAllDiseases();
		assertEquals("Two users should have been created and retrieved", 2,
				diseaseList.size());
	}

	//@Test
	public void testRetrieve() {
		diseaseDAO.addOrUpdateDisease(disease1);
		assertTrue(diseaseDAO.exists(disease1.getName()));

		assertTrue(diseaseDAO.getDiseaseByName(disease1.getName()).equals(
				disease1));
	}

	// @Test
	public void testDelete() {
		diseaseDAO.addOrUpdateDisease(disease1);
		diseaseDAO.addOrUpdateDisease(disease2);

		diseaseDAO.deleteDisease(disease1.getName());
		diseaseDAO.deleteDisease(disease2.getName());

		List<Disease> diseaseList = diseaseDAO.getAllDiseases();
		assertEquals("Three shouldn't be any users in the db", 0,
				diseaseList.size());
	}

	private void addDrugs() {
		drug1 = new Drug("Algocalmin", "potasiu,calciu");
		drug2 = new Drug("Paracetamol", "fier,zinc,calciu");
		drug3 = new Drug("Nurofen", "B12,B7,magneziu");
		drugDAO.addOrUpdateDrug(drug1);
		drugDAO.addOrUpdateDrug(drug2);
		drugDAO.addOrUpdateDrug(drug3);

	}

	private void addDiseases() {
		List<Drug> drugList1 = new ArrayList<Drug>();
		drugList1.add(drug1);
		drugList1.add(drug2);
		disease1 = new Disease("Raceala", SeverityType.Minor,
				drugList1);

		List<Drug> drugList2 = new ArrayList<Drug>();
		drugList2.add(drug3);
		disease2 = new Disease("Infectie",SeverityType.Moderate,
				drugList2);

	}

}