package webLayer;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import daoLayer.DiseaseDAO;
import daoLayer.DoctorDAO;
import daoLayer.DrugDAO;
import daoLayer.InternDAO;
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
public class AddingController {

	private static final String ADD_DRUG_PAGE = "addDrug";

	private static final String ADD_PATIENT_PAGE = "addPatient";

	private static final String ADD_DOCTOR_PAGE = "addDoctor";

	private static final String ADD_INTERN_PAGE = "addIntern";

	private static final String ADD_JANITOR_PAGE = "addJanitor";

	private static final String ADD_SECTION_PAGE = "addSection";

	private static final String ADD_ROOM_PAGE = "addRoom";

	private static final String ADD_DISEASE_PAGE = "addDisease";

	private static final String INFO_PAGE = "infoPage";
	
	
	@Autowired
	private RoomDAO roomDAO;
	@Autowired
	private DrugDAO drugDAO;
	@Autowired
	private InternDAO internDAO;
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private SectionDAO sectionDAO;
	@Autowired
	private DiseaseDAO diseaseDAO;

	@RequestMapping(value = "/addPatient")
	public String showAddPatientPage(Model model) {
		model.addAttribute("patient", new Patient());
		
		List<Section> sectionList = sectionDAO.getAllSections();
		model.addAttribute("sectionList",sectionList);
		
		List<Room> roomList = roomDAO.getAllRooms();
		model.addAttribute("roomList",roomList);
		
		List<Doctor> doctorList = doctorDAO.getAllDoctors();
		model.addAttribute("doctorList",doctorList);

		List<Disease> diseaseList = diseaseDAO.getAllDiseases();
		model.addAttribute("diseaseList",diseaseList);

		return ADD_PATIENT_PAGE;
	}

	@RequestMapping(value = "/addDoctor")
	public String showAddDoctorPage(Model model) {
		model.addAttribute("doctor", new Doctor());
		return ADD_DOCTOR_PAGE;
		
	}

	@RequestMapping(value = "/addDrug")
	public String showAddDrugPage(Model model) {
		model.addAttribute("drug", new Drug());
		return ADD_DRUG_PAGE;
	}

	@RequestMapping(value = "/addIntern")
	public String showAddInternPage(Model model) {
		model.addAttribute("intern", new Intern());
		return ADD_INTERN_PAGE;
	}

	@RequestMapping(value = "/addJanitor")
	public String showAddJanitorPage(Model model) {
		model.addAttribute("janitor", new Janitor());
		return ADD_JANITOR_PAGE;
	}

	@RequestMapping(value = "/addSection")
	public String showAddSectionPage(Model model) {
		model.addAttribute("section", new Section());
		return ADD_SECTION_PAGE;
	}

	@RequestMapping(value = "/addRoom")
	public String showAddRoomPage(Model model) {
		model.addAttribute("room", new Room());
		return ADD_ROOM_PAGE;
	}

	@RequestMapping(value = "/addDisease")
	public String showAddDiseasePage(Model model) {
		model.addAttribute("disease", new Disease());
		return ADD_DISEASE_PAGE;
	}

	@RequestMapping(value = "/doAddDrug", method = RequestMethod.POST)
	public String doAddDrug(@Valid Drug drug, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return ADD_DRUG_PAGE;
		} else {

			if (drugDAO.exists(drug.getName())) {
				result.rejectValue("username", "DuplicateKey.user.username");
				return ADD_DRUG_PAGE;
			}

			drugDAO.addOrUpdateDrug(drug);

			model.addAttribute("info", "Drug successfully created!");
			return INFO_PAGE;
		}
	}
	
	@RequestMapping(value = "/deletePatient")
	public String deletePatient(@RequestParam int pid, Model model) {
		System.out.println("Id is: "  + pid);
		patientDAO.deletePatient(pid);
		model.addAttribute("info", "Patient successfully deleted!");
		return INFO_PAGE;
	}

	
	@RequestMapping(value = "/editPatient")
	public String editPatient(@RequestParam int pid, Model model) {
		Patient patient = patientDAO.getPatientById(pid);
		model.addAttribute("currentPatient",patient);
		deletePatient(pid, model);
		return showAddPatientPage(model);
	}
	
	
	
	@RequestMapping(value = "/doAddPatient", method = RequestMethod.POST)
	public String doAddDoctor(@Validated Patient patient, BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {
			
			List<Section> sectionList = sectionDAO.getAllSections();
			model.addAttribute("sectionList",sectionList);
			
			List<Room> roomList = roomDAO.getAllRooms();
			model.addAttribute("roomList",roomList);
			
			List<Doctor> doctorList = doctorDAO.getAllDoctors();
			model.addAttribute("doctorList",doctorList);

			List<Disease> diseaseList = diseaseDAO.getAllDiseases();
			model.addAttribute("diseaseList",diseaseList);
			
			return ADD_PATIENT_PAGE;
		} else {
			
			patientDAO.addOrUpdatePatient(patient);
			
			model.addAttribute("info", "Patient successfully created!");
			return INFO_PAGE;
		}
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		
		binder.registerCustomEditor(Section.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Section section = sectionDAO.getSectionbyName(text);
				setValue(section);
			}
		});
		binder.registerCustomEditor(Room.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Room room = roomDAO.getRoomByNumber(Integer.parseInt(text));
				setValue(room);
			}
		});
		binder.registerCustomEditor(Doctor.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Doctor doctor = doctorDAO.getDoctorById(Integer.parseInt(text));
				System.out.println("Doctor is "+doctor);
				setValue(doctor);
			}
		});
		binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(new Timestamp(System.currentTimeMillis()));
			}
		});
		binder.registerCustomEditor(Disease.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Disease disease = diseaseDAO.getDiseaseByName(text);
				setValue(disease);
			}
		});
	}
		
}
