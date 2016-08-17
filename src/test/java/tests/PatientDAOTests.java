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
import daoLayer.PatientDAO;
import daoLayer.RoomDAO;
import daoLayer.SectionDAO;
import domainLayer.Disease;
import domainLayer.Doctor;
import domainLayer.Patient;
import domainLayer.Room;
import domainLayer.Section;

@ContextConfiguration(locations = { "classpath:config/dao-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDAOTests {

	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private SectionDAO sectionDAO;
	@Autowired
	private DiseaseDAO diseaseDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private RoomDAO roomDAO;
	@Autowired
	private DataSource dataSource;


	private Patient patient1;
	private Patient patient2;

	private Section section1;
	private Section section2;
	private Section section3;

	private Doctor doctor1;
	private Doctor doctor2;
	private Doctor doctor3;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from patient");
		jdbcTemplate.execute("delete from doctor");
		jdbcTemplate.execute("delete from section");
		addRooms();
		addDiseases();
		addSections();
		addDoctors();
		addPatients();
	}

	private void addDiseases() {
		// TODO Auto-generated method stub
		
	}

	private void addRooms() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testCreate() {
		patientDAO.addOrUpdatePatient(patient1);
		patientDAO.addOrUpdatePatient(patient2);

		List<Patient> patientList = patientDAO.getAllPatients();
		assertEquals("Three users should have been created and retrieved", 2,
				patientList.size());
		assertTrue(true);
	}

	 //@Test
	public void testRetrieve() {
		patientDAO.addOrUpdatePatient(patient1);
		assertTrue(patientDAO.exists(patient1.getId()));
		assertTrue(patientDAO.getPatientById(patient1.getId()).equals(patient1));
	}

	// @Test
	public void testDelete() {
		patientDAO.addOrUpdatePatient(patient1);
		patientDAO.addOrUpdatePatient(patient2);

		patientDAO.deletePatient(patient1.getId());
		patientDAO.deletePatient(patient2.getId());

		List<Patient> patientList = patientDAO.getAllPatients();
		assertEquals("Three shouldn't be any users in the db", 0,
				patientList.size());
	}

	private void addPatients() {

		Timestamp time = new Timestamp(System.currentTimeMillis());
		Disease infection = diseaseDAO.getDiseaseByName("Infectie");
		Disease raceala = diseaseDAO.getDiseaseByName("Raceala");

		Section section1 = sectionDAO.getSectionbyName("Oncologie");
		Section section2 = sectionDAO.getSectionbyName("Pediatrie");
		Section section3 = sectionDAO.getSectionbyName("Terapie Intensiva");

		Room room1 = roomDAO.getRoomByNumber(101);
		Room room2 = roomDAO.getRoomByNumber(345);

		patient1 = new Patient("Ghita", 30, time, infection, section1, room1,doctor1);
		patient2 = new Patient("Maria", 40, time, raceala, section2, room2,doctor2);

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