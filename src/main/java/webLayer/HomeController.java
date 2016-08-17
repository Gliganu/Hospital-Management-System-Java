package webLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daoLayer.DiseaseDAO;
import daoLayer.DoctorDAO;
import daoLayer.DrugDAO;
import daoLayer.InternDAO;
import daoLayer.JanitorDAO;
import daoLayer.PatientDAO;
import daoLayer.RoomDAO;
import daoLayer.SectionDAO;
import domainLayer.Disease;
import domainLayer.Doctor;
import domainLayer.Drug;
import domainLayer.Intern;
import domainLayer.Janitor;
import domainLayer.Patient;
import domainLayer.Room;
import domainLayer.Section;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	private final static String HOME_PAGE = "home";
	private final static String PATIENTS_PAGE = "patients";
	private final static String DOCTORS_PAGE = "doctors";
	private final static String DRUGS_PAGE = "drugs";
	private final static String INTERNS_PAGE = "interns";
	private final static String JANITORS_PAGE = "janitors";
	private final static String SECTIONS_PAGE = "sections";
	private final static String ROOMS_PAGE = "rooms";
	private final static String DISEASES_PAGE = "diseases";
	private final static String PATIENT_DETAILS_PAGE = "patientDetails";
	private final static String ROOMS_DETAILS_PAGE = "roomsDetails";
	private static final String ADMIN_PAGE = "admin";
	
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
	
	@RequestMapping(value="/")
	public String showHomePage(Model model) {
		return HOME_PAGE;
	}
	
	@RequestMapping(value="/showAllPatients")
	public String showAllPatients(Model model){
		List<Patient> patientList = patientDAO.getAllPatients();
		model.addAttribute("patientList",patientList);
		return PATIENTS_PAGE;
	}
	
	@RequestMapping(value="/showAllDoctors")
	public String showAllDoctors(Model model){
		List<Doctor> doctorList = doctorDAO.getAllDoctors();
		model.addAttribute("doctorList",doctorList);
		return DOCTORS_PAGE;
	}
	
	@RequestMapping(value="/showAllDrugs")
	public String showAllDrugs(Model model){
		List<Drug> drugList = drugDAO.getAllDrugs();
		model.addAttribute("drugList",drugList);
		return DRUGS_PAGE;
	}
	
	@RequestMapping(value="/showAllInterns")
	public String showAllInterns(Model model){
		List<Intern> internList = internDAO.getAllInterns();
		model.addAttribute("internList",internList);
		return INTERNS_PAGE;
	}

	@RequestMapping(value="/showAllJanitors")
	public String showAllJanitors(Model model){
		List<Janitor> janitorList = janitorDAO.getAllJanitors();
		model.addAttribute("janitorList",janitorList);
		return JANITORS_PAGE;
	}
	
	@RequestMapping(value="/showAllSections")
	public String showAllSections(Model model){
		List<Section> sectionList = sectionDAO.getAllSections();
		model.addAttribute("sectionList",sectionList);
		return SECTIONS_PAGE;
	}
	
	@RequestMapping(value="/showAllRooms")
	public String showAllRooms(Model model){
		List<Room> roomList = roomDAO.getAllRooms();
		model.addAttribute("roomList",roomList);
		return ROOMS_PAGE;
	}
	
	@RequestMapping(value="/showAllDiseases")
	public String showAllDiseases(Model model){
		List<Disease> diseaseList = diseaseDAO.getAllDiseases();
		model.addAttribute("diseaseList",diseaseList);
		return DISEASES_PAGE;
	}
	/*
	@RequestMapping(value="/getPatientDetails")
	public String getPatientDetails(@RequestParam int did, Model model){
		Doctor doctor = doctorDAO.getDoctorById(did);
		List<Patient> patientList = doctor.getPatientList();
		model.addAttribute("patientList",patientList);
		model.addAttribute("doctorName",doctor.getName());
		return PATIENT_DETAILS_PAGE;
	}
	*/
	
	@RequestMapping(value="/getRoomsDetails")
	public String getRoomsDetails(@RequestParam int jid, Model model){
		Janitor janitor = janitorDAO.getJanitorById(jid);
		List<Room> roomList = roomDAO.getRoomsByJanitor(janitor);
		model.addAttribute("roomList",roomList);
		model.addAttribute("janitorName",janitor.getName());
		return ROOMS_DETAILS_PAGE;
	}
	
	
	@RequestMapping(value="/admin")
	public String showAdminPage(){
		return ADMIN_PAGE;
	}
	
	


}
