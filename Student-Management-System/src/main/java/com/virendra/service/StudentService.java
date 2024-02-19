package com.virendra.service;

import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.stereotype.Service;

import com.virendra.Exception.StudentException;
import com.virendra.models.Student;


public interface StudentService {
	
    public Student createStudent(Student student)throws StudentException;
	
	public Student updateStudent(Student upStudent)throws StudentException;
	
	public Student deleteStudent(Integer studenId) throws StudentException;
	
	public List<Student> viewAllStudents()throws StudentException;

}
