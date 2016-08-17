package webLayer;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daoLayer.UserDAO;
import domainLayer.User;

@Controller
public class AccountController {

	private final static String HOME_PAGE = "home";
	private final static String ADD_NEW_JOKE_PAGE = "addNewJoke";
	private final static String EDIT_PROFILE_PAGE = "editProfile";
	private final static String CHANGE_PASSWORD_PAGE = "changePassword";
	private static final String INFO_PAGE = "infoPage";
	private static final String CONFIRM_DELETE_PAGE = "confirmDelete";


	
	@Autowired
	private UserDAO userDAO;
	

	@RequestMapping(value="/editProfile")
	public String showEditProfilePage(Model model, Principal principal){
		model.addAttribute("currentUsername", principal.getName());
		return EDIT_PROFILE_PAGE;
	}
	
	@RequestMapping(value = "/changePassword")
	public String showChangePasswordPage(Model model) {
		
		model.addAttribute("user", new User());
		return CHANGE_PASSWORD_PAGE;
	}
	
	
	@RequestMapping(value = "/doChangePassword", method=RequestMethod.POST)
	public String doChangePassword(User user, Model model, Principal principal) {
		
		userDAO.changePassword(principal.getName(),user.getPassword());
		model.addAttribute("info", "Password Changed");
		return INFO_PAGE;
		
	}
	
	
	@RequestMapping(value="/deleteAccount")
	public String deleteAccount(Model model,Principal principal) {
		
		userDAO.deleteUser(principal.getName());
		
		return CONFIRM_DELETE_PAGE;
		
		
	}
	
	

}
