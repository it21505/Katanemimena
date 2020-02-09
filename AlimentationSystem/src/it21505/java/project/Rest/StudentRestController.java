package it21505.java.project.Rest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it21505.java.project.Models.Application;
import it21505.java.project.Models.Data;
import it21505.java.project.Models.Student;
import it21505.java.project.Services.StudentServiceImpl;


@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentServiceImpl studentService;
			
	@GetMapping("/students")
    public List<Student> getStudnets() {
		List<Student> students = studentService.getAll();
            return students;
            
    }
	
	@GetMapping("/students/{username}")
    public Student getStudent(@PathVariable String username) {
            Student student = studentService.getStudentByUsername(username);
            return student;      
    }
	
	@GetMapping("/students/rank/{username}")
    public int getStudentRank(@PathVariable String username) {
		
			List<Student> students = studentService.getAll();
            List<Student> approved = studentService.getAllApprovedStudents(students);
            //Sort approved students by 
            Collections.sort(approved, new Comparator<Student>() {
            	@Override
            	  public int compare(Student s1, Student s2) {
            	    return s2.getScore() - s1.getScore();
            	  }
            });
            
            for(int i=0;i<approved.size();i++) {
            	if(approved.get(i).getLogin().getUsername().equals(username))
            	{
            		return i+1;
            	}
            }
            return 0;      
    }
	
	
	@GetMapping("/data")
    public Data getData() {
		Data data = studentService.getData();
		return data;
	}
	
	
	@DeleteMapping("/students/{username}")
    public String deleteStudent(@PathVariable String username) {
            
			Student student = studentService.getStudentByUsername(username);

            if (student == null) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
            }
            int id = student.getId();
           // studentService.delete(id);
            return "Deleted customer id : " + id;
    }

	@PostMapping("/students")
    public boolean addStudent(@RequestBody Student student) {
		
            student.setId(0);
            student.setChecked(false);
            student.setActive(false);
            student.setApproved(false);
            student.setScore(0);        
            boolean exists = studentService.checkIfStudentExists(student.getLogin().getUsername());
            if(!exists) {
            	studentService.save(student);
            	return true;
            }else {
            	return false;
            }
                     
    }
	
	 @PutMapping("/students/application")
     public Student addApplication(@RequestBody Student student) {
        String username = student.getLogin().getUsername();    
		System.out.println(username);
		Student current = studentService.getStudentByUsername(username);
		student.getApplication().setStudent(current);
		student.getIdentification().setStudent(current);
		student.getResidence().setStudent(current);
		current.setSend(true);
		current.setApplication(student.getApplication());
        current.setIdentification(student.getIdentification());
        current.setResidence(student.getResidence());
        
        //System.out.println("id" + current + " username :" + current.getLogin().getUsername() + " " + current.getIdentification().getAdoptionDay());
        studentService.update(current);
            return null;
     }
	 
	 @PutMapping("/students")
     public Student updateStudent(@RequestBody Student student) {
		 String username = student.getLogin().getUsername();    
		 Student current = studentService.getStudentByUsername(username);
		 String email = student.getEmail();
		 String telephone = student.getResidence().getTelephone();
		 String mobile =student.getResidence().getMobile();
		 current.setEmail(email);
		 current.getResidence().setTelephone(telephone);
		 current.getResidence().setMobile(mobile);
		 
		 studentService.update(current);
		 
		 return student;
	 }
	 
	
	@PostMapping("/students/auth")
    public boolean authStudent(@RequestParam String credentials) {		                            
		List<Student> students = studentService.getAll();
		String username = credentials.split(":",0)[0];
		String password = credentials.split(":",0)[1];
			System.out.println(username + " - " + password);
			for(Student s : students) {
				if(s.getLogin().getUsername().equals(username)) {
					if(s.getLogin().getPassword().equals(password)) {						
						return true;
					}
				}
				
			}
            return false;
    }
	
}
