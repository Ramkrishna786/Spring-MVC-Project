package com.string.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
	
		
		Student st = new Student();
		
		st.setStudentId(rs.getInt(1));
		st.setStudentName(rs.getString(2));
		st.setCourse(rs.getString(3));
		st.setFees(rs.getFloat(4));
		
		return st;
	}

}
