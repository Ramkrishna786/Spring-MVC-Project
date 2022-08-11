package com.spring.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.model.Student;
import com.string.mappers.StudentMapper;

public class StudentServiceIMPL implements StudentServiceOperations {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {

		String sql = "insert into student_details values(" + student.getStudentId() + ",'" + student.getStudentName()
				+ "','" + student.getCourse() + "'," + student.getFees() + ")";
		int result = jdbcTemplate.update(sql);
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student_details set sname='" + student.getStudentName() + "', scourse='"
				+ student.getCourse() + "',sfees = " + student.getFees() + " where sno =" + student.getStudentId();
		int result = jdbcTemplate.update(sql);
		return result;
	}

	@Override
	public int deleteStudent(int studentId) {
		String sql = "delete from student_details where sno=" + studentId;
		int result = jdbcTemplate.update(sql);
		return result;
	}

	@Override
	public Student searchStudent(int studentId) {
		String sql = "select * from student_details where sno=" + studentId;
		
	return jdbcTemplate.queryForObject(sql, new StudentMapper());
	}

	@Override
	public List<Student> showAll() { // TODO Auto-generated method stub
	
		String sql = "select * from student_details";		
		return jdbcTemplate.query(sql,new StudentMapper());
		
	}

}
