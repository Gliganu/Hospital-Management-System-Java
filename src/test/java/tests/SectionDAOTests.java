package tests;

import static org.junit.Assert.*;
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

import daoLayer.SectionDAO;
import domainLayer.Section;

@ContextConfiguration(locations = {
		"classpath:config/dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)


public class SectionDAOTests {

	@Autowired
	private SectionDAO sectionDAO;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from section");

	}
	
	private Section section1 =  new Section("Terapie Intensiva", new Timestamp(System.currentTimeMillis()));
	private Section section2 =  new Section("Oncologie", new Timestamp(System.currentTimeMillis()));
	private Section section3 =  new Section("Pediatrie", new Timestamp(System.currentTimeMillis()));

	@Test
	public void testCreate() {
		sectionDAO.addOrUpdateSection(section1);
		sectionDAO.addOrUpdateSection(section2);
		sectionDAO.addOrUpdateSection(section3);

		List<Section> sectionList = sectionDAO.getAllSections();
		assertEquals("Three sections should have been created and retrieved", 3,
				sectionList.size());
	}
	
	//@Test 
	public void testRetrieve(){
		sectionDAO.addOrUpdateSection(section1);
		assertTrue(sectionDAO.exists(section1.getName()));
		assertTrue(sectionDAO.getSectionbyName(section1.getName()).equals(section1));
	}
	
	//@Test 
	public void testDelete(){
		sectionDAO.addOrUpdateSection(section1);
		sectionDAO.addOrUpdateSection(section2);
		
		sectionDAO.deleteSection(section1.getName());
		sectionDAO.deleteSection(section2.getName());
		
		List<Section> userList = sectionDAO.getAllSections();
		assertEquals("Three shouldn't be any users in the db", 0,
				userList.size());
	}
	

}