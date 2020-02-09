package it21505.java.project.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it21505.java.project.DAO.StudentDAO;
import it21505.java.project.Models.Application;
import it21505.java.project.Models.Data;
import it21505.java.project.Models.Identification;
import it21505.java.project.Models.Login;
import it21505.java.project.Models.Residence;
import it21505.java.project.Models.Student;
import it21505.java.project.Services.StudentServiceImpl;

@Controller
@RequestMapping("/user")
public class EmployeeController {	
	
	@Autowired
	private StudentServiceImpl studentService;
	
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
		Student student = studentService.getStudentById(id);
		model.addAttribute("student",student);
		return "user-check-student";
	}
	
	@RequestMapping("/check-application")
	public String showCheckApplicationPage(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentService.getStudentById(id);
		model.addAttribute("student",student);
		return "user-check-application";
	}
	
	@RequestMapping("/update-limit")
	public String showUpdateLimitPage(HttpServletRequest request,Model model) {
		int totalStudents = studentService.getData().getTotal();
		int limit  = Integer.parseInt(studentService.getData().getLimit());
		int number = (totalStudents * limit)/100;
		model.addAttribute("total",totalStudents);
		model.addAttribute("number",number);
		return "user-update-limit";
	}
	
	@RequestMapping(value = "/processUpdateLimit" , method=RequestMethod.POST )
	public String processUpdateLimit(HttpServletRequest request, Model model) {
	String limit  = request.getParameter("limit");
	Data data = studentService.getData();
	data.setLimit(limit);
	data.setOpen(true);
	studentService.updateData(data);
	return "redirect:/user/update-limit?success";
}
	
	@RequestMapping("/student-list")
	public String showStudentListPage(Model model) {
		List<Student> allstudents = studentService.getAll();
		List<Student> unchecked = studentService.getAllUncheckedStudents(allstudents); 
		model.addAttribute("students", unchecked);
		return "user-student-list";
		
	}
	
	@RequestMapping(value = "/processDeclineStudent" , method=RequestMethod.GET )
		public String processDeclineStudent(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentService.getStudentById(id);
		student.setChecked(true);
		student.setActive(false);
		try {
		studentService.update(student);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "redirect:/user/student-list?derror";
		}
		return "redirect:/user/student-list?dsuccess";
		
	}
	
	@RequestMapping(value = "/processActivateStudent" , method=RequestMethod.GET )
		public String processActivateStudent(HttpServletRequest request, Model model) {
			String id = request.getParameter("id");
			Student student = studentService.getStudentById(id);
			student.setChecked(true);
			student.setActive(true);
			try {
			studentService.update(student);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return "redirect:/user/student-list?aerror";
			}
			return "redirect:/user/student-list?asuccess";
			
		}
	
	@RequestMapping("/application-list")
	public String showApplicationListPage(Model model) {
		List<Student> allstudents = studentService.getAll();
		List<Student> unchecked = studentService.getsAllUncheckedApplications(allstudents); 
		model.addAttribute("students", unchecked);
		return "user-application-list";
		
	}
	
	@RequestMapping(value = "/processDeclineApplication" , method=RequestMethod.GET )
	public String processDeclineApplication(HttpServletRequest request, Model model) {
	String id = request.getParameter("id");
	Student student = studentService.getStudentById(id);
	
	Identification ident = new Identification();
	Residence res = new Residence();
	Application app = new Application();
	Student newStudent = student;
	
	newStudent.setIdentification(ident);
	newStudent.setResidence(res);
	newStudent.setApplication(app);
	student.setSend(false);
	student.setApproved(false);
	
	studentService.update(student);
	return "redirect:/user/home";
}

@RequestMapping(value = "/processApproveApplication" , method=RequestMethod.GET )
	public String processApproveApplication(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Student student = studentService.getStudentById(id);
		student.setApproved(true);
		int score = student.calculateScore();
		System.out.println(score);
		student.setScore(score);
		try {
		studentService.update(student);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/user/home?asuccess";
		}
		return "redirect:/user/home?asuccess";
	}

@RequestMapping("/options")
public String showOptionsPage(Model model) {
	int totalStudents = studentService.getData().getTotal();	
	model.addAttribute("total",totalStudents);
	return "user-options";
	
}

@RequestMapping(value = "/processFinish" , method=RequestMethod.POST )
public String processFinish(HttpServletRequest request, Model model) {
	Data data = studentService.getData();
	data.setOpen(false);
	studentService.updateData(data);
	System.out.println("Data updated");
	return "redirect:/user/options?success";
}



	
}

