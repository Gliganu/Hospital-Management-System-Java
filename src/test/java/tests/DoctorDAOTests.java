package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
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
import daoLayer.DoctorDAO;
import daoLayer.RoomDAO;
import daoLayer.SectionDAO;
import domainLayer.Disease;
import domainLayer.Doctor;
import domainLayer.Drug;
import domainLayer.Patient;
import domainLayer.Room;
import domainLayer.Section;
import domainLayer.SeverityType;

@ContextConfiguration(locations = { "classpath:config/dao-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DoctorDAOTests {

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private SectionDAO sectionDAO;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private DiseaseDAO diseaseDAO;
	@Autowired
	private RoomDAO roomDAO;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from patient");
		jdbcTemplate.execute("delete from doctor");
		jdbcTemplate.execute("delete from intern");
		jdbcTemplate.execute("delete from section");
		addSections();
		addDoctors();
	}

	private Section section1;
	private Section section2;
	private Section section3;

	private Doctor doctor1;
	private Doctor doctor2;
	private Doctor doctor3;

	private Patient patient1;
	private Patient patient2;

	// @Test
	public void testCreate() {
		doctorDAO.addOrUpdateDoctor(doctor1);
		doctorDAO.addOrUpdateDoctor(doctor2);
		doctorDAO.addOrUpdateDoctor(doctor3);

		List<Doctor> doctorList = doctorDAO.getAllDoctors();
		assertEquals("Three users should have been created and retrieved", 3,
				doctorList.size());
	}

	// @Test
	public void testRetrieve() {
		doctorDAO.addOrUpdateDoctor(doctor1);
		assertTrue(doctorDAO.exists(doctor1.getId()));

		assertTrue(doctorDAO.getDoctorById(doctor1.getId()).equals(doctor1));
	}

	@Test
	public void testRetrieve2() {
		doctorDAO.addOrUpdateDoctor(doctor1);
		assertTrue(doctorDAO.exists(doctor1.getId()));

		Doctor retrievedDoctor = doctorDAO.getDoctorByName(doctor1.getName());
		System.out.println(retrievedDoctor.getName());
		assertTrue(retrievedDoctor.equals(doctor1));
	}

	// @Test
	public void testDelete() {
		doctorDAO.addOrUpdateDoctor(doctor1);
		doctorDAO.addOrUpdateDoctor(doctor2);

		doctorDAO.deleteDoctor(doctor1.getId());
		doctorDAO.deleteDoctor(doctor2.getId());

		List<Doctor> doctorList = doctorDAO.getAllDoctors();
		assertEquals("Three shouldn't be any users in the db", 0,
				doctorList.size());
	}

	private void addDoctors() {
		doctor1 = new Doctor("Dr.Muscolo", 55, 30, section1);
		doctor2 = new Doctor("Dr.Marinescu", 54, 35, section2);
		doctor3 = new Doctor("Dr.Agabei", 43, 23, section3);
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

}