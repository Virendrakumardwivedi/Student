package com.virendra.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virendra.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
