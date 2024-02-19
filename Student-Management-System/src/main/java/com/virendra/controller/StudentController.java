package com.virendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.virendra.Exception.StudentException;
import com.virendra.models.Student;
import com.virendra.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeHandler(){
		return new ResponseEntity<String>("Welcome to Student App !",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/newstudent")
	public ResponseEntity<Student> addNewStudents(@RequestBody Student student)throws StudentException{
		
		Student newStudent = studentService.createStudent(student);
		return new ResponseEntity<Student>(newStudent,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("studentId") Integer studentId) throws StudentException{
		
		Student stu = studentService.deleteStudent(studentId);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student stu = studentService.updateStudent(student);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
	}

	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllEmployes()throws StudentException{
	
		List<Student> listAllStudent = studentService.viewAllStudents();
		return new ResponseEntity<List<Student>>(listAllStudent,HttpStatus.OK);
		
	}
	

}
