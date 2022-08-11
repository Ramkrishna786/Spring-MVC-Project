package com.spring.service;

import java.util.List;

import com.spring.model.Student;

public interface StudentServiceOperations {

	
	public int addStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int  studentId);
	public Student searchStudent(int studentId);
	public List<Student> showAll();
	
	
}
