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

import daoLayer.InternDAO;
import daoLayer.SectionDAO;
import domainLayer.Intern;
import domainLayer.Section;
import domainLayer.User;

@ContextConfiguration(locations = {
		"classpath:config/dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)


public class InternDAOTests {

	@Autowired
	private InternDAO internDAO;
	@Autowired
	private SectionDAO sectionDAO;


	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from intern");
		jdbcTemplate.execute("delete from section");
		addSections();
		addInterns();
	}


	private Section section1;
	private Section section2;
	private Section section3;

	private Intern intern1;
	private Intern intern2;
	private Intern intern3; 

	@Test
	public void testCreate() {
		internDAO.addOrUpdateIntern(intern1);
		internDAO.addOrUpdateIntern(intern2);
		internDAO.addOrUpdateIntern(intern3);

		List<Intern> internList = internDAO.getAllInterns();
		assertEquals("Three users should have been created and retrieved", 3,
				internList.size());
	}
	
	@Test 
	public void testRetrieve(){
		internDAO.addOrUpdateIntern(intern1);
		assertTrue(internDAO.exists(intern1.getId()));
		assertTrue(internDAO.getInternById(intern1.getId()).equals(intern1));
	}
	
	@Test 
	public void testDelete(){
		internDAO.addOrUpdateIntern(intern1);
		internDAO.addOrUpdateIntern(intern2);
		
		internDAO.deleteIntern(intern1.getId());
		internDAO.deleteIntern(intern2.getId());
		
		List<Intern> internList = internDAO.getAllInterns();
		assertEquals("Three shouldn't be any users in the db", 0,
				internList.size());
	}
	
	
	private void addSections() {
		 section1 = new Section("Terapie Intensiva", new Timestamp(
				System.currentTimeMillis()));
		 section2 = new Section("Oncologie", new Timestamp(
				System.currentTimeMillis()));
		 section3 = new Section("Pediatrie", new Timestamp(
				System.currentTimeMillis()));

		sectionDAO.addOrUpdateSection(section1);
		sectionDAO.addOrUpdateSection(section2);
		sectionDAO.addOrUpdateSection(section3);
	}
	
	
	private void addInterns() {
		 intern1 =  new Intern("Andrew", 30, section1);
		 intern2 =  new Intern("Joanna", 25, section2);
		 intern3 =  new Intern("Larissa", 21, section3);
	}
	

}