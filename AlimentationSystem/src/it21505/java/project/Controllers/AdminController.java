package it21505.java.project.Controllers;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it21505.java.project.DAO.StudentDAO;
import it21505.java.project.DAO.UserDAO;
import it21505.java.project.Models.Authorities;
import it21505.java.project.Models.Student;
import it21505.java.project.Models.User;
import it21505.java.project.Services.UserServiceImpl;

@Controller
@RequestMapping("/admin")
@EnableTransactionManagement(proxyTargetClass = true)
public class AdminController{
	
	@Autowired
	private UserServiceImpl userService;
		
	@RequestMapping("/login")
	public String showALoginPage() {
		return "admin-login";
	}
		
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String showHomePage(Model model) {
		List<User> allusers = userService.getAll();
		model.addAttribute("allusers", allusers);
		return "admin-home";
	}
	
	@RequestMapping("/add")
	public String showAddPage() {
		return "admin-add";
	}
	
	@RequestMapping(value = "/processAdminAddForm" , method=RequestMethod.POST )
	public String processAddForm(HttpServletRequest request, Model model) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		String roles[] = request.getParameterValues("roles");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String encpass = passwordEncoder(password);
		User user = new User(username,encpass,name,surname,email);
		userService.saveUser(user);
		for(String role : roles) {
			Authorities authority = new Authorities(role,user);
			userService.saveRole(authority);
		}
		
		//Authorities authority = new Authorities(roles,user);
		//user.getAuthorities().add(authority);		
		//userService.save(user,authority);
		return "redirect:/admin/home";
	}
	
	@RequestMapping("/update")
	public String showUpdatePage(HttpServletRequest request, Model model) {		
		if(request.getParameter("userId")==null) {
			System.out.println("Id is null");
			return "redirect:/home";
		}
		String id = request.getParameter("userId");
		User user = userService.getUserById(id);
	    model.addAttribute("user",user);
		return "admin-update";
	}
	
	@RequestMapping(value = "/processAdminUpdateForm" , method=RequestMethod.POST )
	public String processUpdateForm(HttpServletRequest request, Model model) {		
		String prevUsername = request.getParameter("id");
		int id = userService.getIdByUsername(prevUsername);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roles[] = request.getParameterValues("roles");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String encpass = passwordEncoder(password);
		User user = new User(username + " " + prevUsername,encpass,name,surname,email);
		
		userService.deleteRole(prevUsername);
		userService.updateUser(user);
		user = new User(username,encpass,name,surname,email);
		for(String role : roles) {			
			Authorities authority = new Authorities(role,user);
			userService.saveRole(authority);
		}
		
		
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/processAdminDeleteForm" , method=RequestMethod.GET )
	public String processDeleteForm(HttpServletRequest request, Model model) {
		String id = request.getParameter("userId");
		System.out.println(id);
		userService.deleteRole(id);
		userService.deleteUser(id);		
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/roles" , method=RequestMethod.GET )
	public String showRolesForm(Model model) {
		List<User> allusers = userService.getAll();
		model.addAttribute("allusers", allusers);
		return "admin-roles";
	}
	
	@RequestMapping(value = "/processAlgo" , method=RequestMethod.POST )
	public String processAlgo(HttpServletRequest request, Model model) {
		String roles[] = request.getParameterValues("roles");
		System.out.println(roles[1]);
		return null;
	}
	
	
	public String passwordEncoder(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String code = encoder.encode(password);		
		return code;
	}
	
}
