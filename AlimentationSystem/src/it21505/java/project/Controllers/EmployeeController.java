package it21505.java.project.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it21505.java.project.DAO.StudentDAO;
import it21505.java.project.Models.Student;

@Controller
@RequestMapping("/user")
public class EmployeeController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "user-login";
	}
	
	@RequestMapping("/home")
	public String showHomePage() {
		return "user-home";
	}
	
	@RequestMapping("/check-student")
	public String showCheckStudentPage(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentDAO.getUserById(id);
		model.addAttribute("student",student);
		return "user-check-student";
	}
	
	@RequestMapping("/check-application")
	public String showCheckApplicationPage(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentDAO.getUserById(id);
		model.addAttribute("student",student);
		return "user-check-application";
	}
	
	@RequestMapping("/update-limit")
	public String showUpdateLimitPage() {
		return "user-update-limit";
	}
	
	@RequestMapping("/student-list")
	public String showStudentListPage(Model model) {
		List<Student> allstudents = studentDAO.getAll();
		model.addAttribute("allstudents", allstudents);
		return "user-student-list";
		
	}
	
	@RequestMapping(value = "/processDeclineStudent" , method=RequestMethod.GET )
		public String processDeclineStudent(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentDAO.getUserById(id);
		student.setActive(false);
		student.setChecked(true);
		return null;
	}
	
	@RequestMapping(value = "/processActivateStudent" , method=RequestMethod.GET )
		public String processActivateStudent(HttpServletRequest request, Model model) {
			String id = request.getParameter("id");
			Student student = studentDAO.getUserById(id);
			int score = student.calculateScore();
			student.setScore(score);
			return null;
		}
	
	
	}

