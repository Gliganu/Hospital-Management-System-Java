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

import daoLayer.JanitorDAO;
import domainLayer.Intern;
import domainLayer.Janitor;
import domainLayer.Section;

@ContextConfiguration(locations = {
		"classpath:config/dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)


public class JanitorDAOTests {

	@Autowired
	private JanitorDAO janitorDAO;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from janitor");
	}
	
	private Janitor janitor1 = new Janitor("Nea Vasile");
	private Janitor janitor2 = new Janitor("Olguta");
	private Janitor janitor3 = new Janitor("Nea Costica");
	


	@Test
	public void testCreate() {
		janitorDAO.addOrUpdateJanitor(janitor1);
		janitorDAO.addOrUpdateJanitor(janitor2);
		janitorDAO.addOrUpdateJanitor(janitor3);

		List<Janitor> janitorList = janitorDAO.getAllJanitors();
		assertEquals("Three users should have been created and retrieved", 3,
				janitorList.size());
	}
	
	//@Test 
	public void testRetrieve(){
		janitorDAO.addOrUpdateJanitor(janitor1);
		assertTrue(janitorDAO.exists(janitor1.getId()));
		assertTrue(janitorDAO.getJanitorById(janitor1.getId()).equals(janitor1));
	}
	
	//@Test 
	public void testDelete(){
		janitorDAO.addOrUpdateJanitor(janitor1);
		janitorDAO.addOrUpdateJanitor(janitor2);
		
		janitorDAO.deleteJanitor(janitor1.getId());
		janitorDAO.deleteJanitor(janitor2.getId());
		
		List<Janitor> janitorList = janitorDAO.getAllJanitors();
		assertEquals("Three shouldn't be any users in the db", 0,
				janitorList.size());
	}

	

}