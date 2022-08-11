package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Student;
import com.spring.service.StudentServiceOperations;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceOperations studentServiceOperations;

	@RequestMapping("/addStudentForm")
	public String showStudentForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);

		return "addStudentForm";

	}

	@RequestMapping(value = "/addStudentDetails", method = RequestMethod.POST)
	public String addStudentDetails(@ModelAttribute("student") Student student) {

		int result = studentServiceOperations.addStudent(student);
		if (result > 0) {
			return "redirect:/viewAllStudents";
		}

		else {
			return "";
		}
	}

	@RequestMapping("/viewAllStudents") // show all students record
	public String viewAllStudents(Model model) {

		List<Student> studentsList = studentServiceOperations.showAll();
		model.addAttribute("studentsList", studentsList);
		return "showStudents";

	}

	// it display selected student record
	@RequestMapping("/editstudent/{studentId}")
	public String editForm(@PathVariable("studentId") int studentId, Model model) {

		Student student = studentServiceOperations.searchStudent(studentId);  
		model.addAttribute("student", student);
		return "editstudentform";
	}

	// updating selected student record
	@RequestMapping(value = "/updatestudentDetails", method = RequestMethod.POST)
	public String updateStudentDetails(@ModelAttribute("student") Student student) {

		int result = studentServiceOperations.updateStudent(student);
		if (result > 0) {
			return "redirect:/viewAllStudents";
		}

		else {
			return "";
		}
	}

	@RequestMapping("/deletestudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId) {

		int result = studentServiceOperations.deleteStudent(studentId);

		if (result > 0) {
			return "redirect:/viewAllStudents";
		}

		else {
			return "";
		}

	}

}
