package tests;



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
import daoLayer.DrugDAO;
import daoLayer.InternDAO;
import daoLayer.JanitorDAO;
import daoLayer.PatientDAO;
import daoLayer.RoomDAO;
import daoLayer.SectionDAO;
import daoLayer.UserDAO;
import domainLayer.Disease;
import domainLayer.Doctor;
import domainLayer.Drug;
import domainLayer.Intern;
import domainLayer.Janitor;
import domainLayer.Patient;
import domainLayer.Room;
import domainLayer.Section;
import domainLayer.SeverityType;
import domainLayer.User;

@ContextConfiguration(locations = { "classpath:config/dao-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RestoreDbState {

	@Autowired
	private UserDAO usersDAO;
	@Autowired
	private SectionDAO sectionDAO;
	@Autowired
	private InternDAO internDAO;
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private JanitorDAO janitorDAO;
	@Autowired
	private DrugDAO drugDAO ;
	@Autowired
	private RoomDAO roomDAO ;
	@Autowired
	private DiseaseDAO diseaseDAO;
	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private DataSource dataSource;

	private Section section1;
	private Section section2;
	private Section section3;
	private Section section4;
	private Section section5;
	
	private Intern intern1;
	private Intern intern2;
	private Intern intern3;
	private Intern intern4;
	private Intern intern5;
	private Intern intern6;
	
	private Doctor doctor1;
	private Doctor doctor2;
	private Doctor doctor3;
	private Doctor doctor4;
	private Doctor doctor5;
	
	private Janitor janitor1 ;
	private Janitor janitor2 ;
	private Janitor janitor3 ;
	private Janitor janitor4 ;
	private Janitor janitor5 ;
	
	private Room room1;
	private Room room2;
	private Room room3;
	private Room room4;
	private Room room5;
	
	private Drug drug1;
	private Drug drug2;
	private Drug drug3;
	private Drug drug4;
	private Drug drug5;
	
	private Disease disease1;
	private Disease disease2;
	private Disease disease3;
	private Disease disease4;
	private Disease disease5;
	
	private Patient patient1;
	private Patient patient2;
	private Patient patient3;
	private Patient patient4;
	private Patient patient5;
	private Patient patient6;
	private Patient patient7;
	private Patient patient8;
	private Patient patient9;
	
	@Before
	public void init() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Test
	public void addAll() {
		testAddUsers();
		addSections();
		addInterns();
		addJanitors();
		addRooms();
		addDrugs();
		addDiseases();
		addDoctors();
		addPatients();
		assertTrue(true);
	}

	
	private void addPatients() {
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Disease disease1 = diseaseDAO.getDiseaseByName("Meningitis");
		Disease disease2 = diseaseDAO.getDiseaseByName("Infection");
		Disease disease3 = diseaseDAO.getDiseaseByName("Hepatitis");
		Disease disease4 = diseaseDAO.getDiseaseByName("Sore Throat");
		Disease disease5 = diseaseDAO.getDiseaseByName("Fracture");
		
		Section section1  = sectionDAO.getSectionbyName("Intensive Therapy");
		Section section2  = sectionDAO.getSectionbyName("Oncology");
		Section section3  = sectionDAO.getSectionbyName("Gynecology");
		Section section4  = sectionDAO.getSectionbyName("ICU");
		Section section5  = sectionDAO.getSectionbyName("Pediatry");
		
		Room room1 =  roomDAO.getRoomByNumber(101);
		Room room2 =  roomDAO.getRoomByNumber(345);
		Room room3 =  roomDAO.getRoomByNumber(543);
		Room room4 =  roomDAO.getRoomByNumber(222);
		Room room5 =  roomDAO.getRoomByNumber(342);
		
		patient1 =  new Patient("Ghita", 30, time, disease1, section1, room1,doctor1);
		patient2 =  new Patient("Maria", 40, time, disease2, section2, room2,doctor1);
		patient3 =  new Patient("Ion", 20, time, disease3, section3, room3,doctor3);
		patient4 =  new Patient("George", 21, time, disease3, section2, room3,doctor2);
		patient5 =  new Patient("Ioana", 25, time, disease4, section4, room4,doctor5);
		patient6 =  new Patient("Mihaela", 43, time, disease5, section5, room5,doctor3);
		patient7 =  new Patient("Vlad", 34, time, disease3, section3, room5,doctor4);
		patient8 =  new Patient("Cristina", 54, time, disease2, section2, room4,doctor2);
		patient9 =  new Patient("Ionut", 33, time, disease5, section1, room2,doctor2);
		
		patientDAO.addOrUpdatePatient(patient1);
		patientDAO.addOrUpdatePatient(patient2);
		patientDAO.addOrUpdatePatient(patient3);
		patientDAO.addOrUpdatePatient(patient4);
		patientDAO.addOrUpdatePatient(patient5);
		patientDAO.addOrUpdatePatient(patient6);
		patientDAO.addOrUpdatePatient(patient7);
		patientDAO.addOrUpdatePatient(patient8);
		patientDAO.addOrUpdatePatient(patient9);
		
	}

	private void addDiseases() {
		List<Drug> drugList1 = new ArrayList<Drug>();
		drugList1.add(drug1);
		drugList1.add(drug2);
		disease1 = new Disease("Meningitis", SeverityType.Minor,
				drugList1);

		List<Drug> drugList2 = new ArrayList<Drug>();
		drugList2.add(drug3);
		disease2 = new Disease("Infection", SeverityType.Moderate,
				drugList2);
		
		List<Drug> drugList3 = new ArrayList<Drug>();
		drugList3.add(drug3);
		drugList3.add(drug1);
		drugList3.add(drug5);
		disease3 = new Disease("Hepatitis", SeverityType.Critical,
				drugList3);
		
		List<Drug> drugList4 = new ArrayList<Drug>();
		drugList4.add(drug4);
		drugList4.add(drug1);
		disease4 = new Disease("Sore Throat", SeverityType.Minor,
				drugList4);
		
		List<Drug> drugList5 = new ArrayList<Drug>();
		drugList5.add(drug5);
		disease5 = new Disease("Fracture", SeverityType.Moderate,
				drugList5);
		
		diseaseDAO.addOrUpdateDisease(disease1);
		diseaseDAO.addOrUpdateDisease(disease2);	
		diseaseDAO.addOrUpdateDisease(disease3);	
		diseaseDAO.addOrUpdateDisease(disease4);	
		diseaseDAO.addOrUpdateDisease(disease5);	
		
	}

	private void addDrugs() {
		drug1 = new Drug("Algocalmin", "potasiu,calciu", null);
		drug2 = new Drug("Paracetamol", "fier,zinc,calciu", null);
		drug3 = new Drug("Nurofen", "B12,B7,magneziu", null);
		drug4 = new Drug("Furazolidon", "zic,magneziu,fier", null);
		drug5 = new Drug("Strepsils", "menta,miere", null);

		drugDAO.addOrUpdateDrug(drug1);
		drugDAO.addOrUpdateDrug(drug2);
		drugDAO.addOrUpdateDrug(drug3);
		drugDAO.addOrUpdateDrug(drug4);
		drugDAO.addOrUpdateDrug(drug5);
		
	}

	private void addRooms() {
		room1 = new Room(101, 1, janitor1);
		room2 = new Room(345, 6, janitor3);
		room3 = new Room(543, 5, janitor3);
		room4 = new Room(222, 2, janitor5);
		room5 = new Room(342, 3, janitor5);
		roomDAO.addOrUpdateRoom(room1);
		roomDAO.addOrUpdateRoom(room2);
		roomDAO.addOrUpdateRoom(room3);
		roomDAO.addOrUpdateRoom(room4);
		roomDAO.addOrUpdateRoom(room5);
	}
		
	private void addJanitors() {
		janitor1 = new Janitor("Nea Vasile");
		janitor2 = new Janitor("Olguta");
		janitor3 = new Janitor("Nea Costica");
		janitor4 = new Janitor("Maricica");
		janitor5 = new Janitor("Nea FLorin");
		
		janitorDAO.addOrUpdateJanitor(janitor1);
		janitorDAO.addOrUpdateJanitor(janitor2);
		janitorDAO.addOrUpdateJanitor(janitor3);
		janitorDAO.addOrUpdateJanitor(janitor4);
		janitorDAO.addOrUpdateJanitor(janitor5);
		
	}

	private void addDoctors() {
		doctor1 =new Doctor("Dr.Muscolo",55, 30, section1);
		doctor2 =new Doctor("Dr.Marinescu", 54, 35, section2);
		doctor3 =new Doctor("Dr.Agabei", 47, 10, section3);
		doctor4 =new Doctor("Dr.Muresan", 65, 28, section4);
		doctor5 =new Doctor("Dr.Demian", 33, 10, section5);
		
		doctorDAO.addOrUpdateDoctor(doctor1);
		doctorDAO.addOrUpdateDoctor(doctor2);
		doctorDAO.addOrUpdateDoctor(doctor3);
		doctorDAO.addOrUpdateDoctor(doctor4);
		doctorDAO.addOrUpdateDoctor(doctor5);
		
	}

	private void addInterns() {
		intern1 = new Intern("Andrew", 30, section1);
		intern2 = new Intern("Joanna", 25, section2);
		intern3 = new Intern("Larissa", 21, section3);
		intern4 = new Intern("Michael", 30, section3);
		intern5 = new Intern("John", 35, section4);
		intern6 = new Intern("Clara", 22, section5);

		internDAO.addOrUpdateIntern(intern1);
		internDAO.addOrUpdateIntern(intern2);
		internDAO.addOrUpdateIntern(intern3);
		internDAO.addOrUpdateIntern(intern4);
		internDAO.addOrUpdateIntern(intern5);
		internDAO.addOrUpdateIntern(intern6);

	}

	private void addSections() {
		section1 = new Section("Intensive Therapy", new Timestamp(
				System.currentTimeMillis()));
		section2 = new Section("Oncology", new Timestamp(
				System.currentTimeMillis()));
		section3 = new Section("Gynecology", new Timestamp(
				System.currentTimeMillis()));
		section4 = new Section("ICU", new Timestamp(
				System.currentTimeMillis()));
		section5= new Section("Pediatry", new Timestamp(
				System.currentTimeMillis()));

		sectionDAO.addOrUpdateSection(section1);
		sectionDAO.addOrUpdateSection(section2);
		sectionDAO.addOrUpdateSection(section3);
		sectionDAO.addOrUpdateSection(section4);
		sectionDAO.addOrUpdateSection(section5);

	}

	public void testAddUsers() {
		User user1 = new User("Gliga", "pass", "ROLE_USER");
		User user2 = new User("Mihai", "pass", "ROLE_ADMIN");
		User user3 = new User("Andreea", "pass", "ROLE_USER");
		usersDAO.addOrUpdateUser(user1);
		usersDAO.addOrUpdateUser(user2);
		usersDAO.addOrUpdateUser(user3);
	}

}