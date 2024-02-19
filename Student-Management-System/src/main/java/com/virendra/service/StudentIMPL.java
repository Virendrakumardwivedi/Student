package com.virendra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virendra.Exception.StudentException;
import com.virendra.models.Student;
import com.virendra.repositroy.StudentRepo;

@Service
public class StudentIMPL implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;



	@Override
	public Student createStudent(Student student) throws StudentException {
		
		Student stud = studentRepo.save(student);
		return stud;
	}


	@Override
	public Student updateStudent(Student upStudent) throws StudentException {
		
        Optional<Student> opt = studentRepo.findById(upStudent.getId());
		
		if(opt.isPresent()) {
			Student updatingStudent = studentRepo.save(upStudent);
			return updatingStudent;
		}
		else
		{
			throw new StudentException("Student not fount...! ");
		}
	}


	@Override
	public Student deleteStudent(Integer studenId) throws StudentException {
        Optional<Student> opt = studentRepo.findById(studenId);
		
		if(opt.isEmpty()) {
			Student existingStudent = opt.get();
			studentRepo.delete(existingStudent);
			return existingStudent;
		}
		else {
			throw new StudentException("Student not fount with this id "+studenId);
		}
		
	}
	
	@Override
	public List<Student> viewAllStudents() throws StudentException {
        List<Student> StudentList = studentRepo.findAll();
		
		if(StudentList.size()==0) {
			throw new StudentException("Student not found");
		}
		else {
			return StudentList;
		}
	}

}
