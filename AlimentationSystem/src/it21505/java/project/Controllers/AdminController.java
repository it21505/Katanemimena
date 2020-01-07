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

@Controller
@RequestMapping("/admin")
@EnableTransactionManagement(proxyTargetClass = true)
public class AdminController{
	
	@Autowired
	private UserDAO userDAO;
		
	@RequestMapping("/login")
	public String showALoginPage() {
		return "admin-login";
	}
	
	
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String showHomePage(Model model) {
		List<User> allusers = userDAO.getAll();
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
		String role = request.getParameter("role");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String encpass = passwordEncoder(password);
		User user = new User(username,encpass,name,surname,email);	
		Authorities authority = new Authorities(role,user);
		user.getAuthorities().add(authority);		
		userDAO.save(user);
		return "redirect:/admin/home";
	}
	
	@RequestMapping("/update")
	public String showUpdatePage(HttpServletRequest request, Model model) {		
		if(request.getParameter("userId")==null) {
			System.out.println("Id is null");
			return "redirect:/home";
		}
		String id = request.getParameter("userId");
		User user = userDAO.getUserById(id);
	    model.addAttribute("user",user);
		return "admin-update";
	}
	
	@RequestMapping(value = "/processAdminUpdateForm" , method=RequestMethod.POST )
	public String processUpdateForm(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String encpass = passwordEncoder(password);
		User user = new User(username,encpass,name,surname,email);
		Authorities authority = new Authorities(role,user);
		user.getAuthorities().add(authority);		
		userDAO.update(user);
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/processAdminDeleteForm" , method=RequestMethod.GET )
	public String processDeleteForm(HttpServletRequest request, Model model) {
		String id = request.getParameter("userId");
		System.out.println(id);
		userDAO.delete(id);
		return "redirect:/admin/home";
	}
	
	public String passwordEncoder(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String code = encoder.encode(password);		
		return code;
	}
	
}
