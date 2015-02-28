package com.jayasree.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jayasree.spring.model.Student;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	//Map to store employees, ideally we should use database
	Map<String, Student> studentData = new HashMap<String, Student>();
	
	/** 
	 * @return gets a dummy value
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = StudentConstants.DUMMY_STUDENT, method = RequestMethod.GET)
	public @ResponseBody Student getDummyStudent() {
		
		
		logger.info("Start getDummyStudent");
		Student student = new Student();
		student.setId(student.getSerialversionuid());
		student.setStudentNumber("123832");
		student.setGender("Male");
		student.setBirthDate("2005-06-15");
		student.setDisability(false);
		student.setFirstName("Hock");
		student.setLastName("Chahine");
		student.setEmail("hock.chahine@river-district.com");
		return student;
	}
	
	/**
	 * @param studentId
	 * @return returns the student
	 */
	@RequestMapping(value = StudentConstants.GET_STUDENT, method = RequestMethod.GET)
	public @ResponseBody Student getStudent(@PathVariable("id") String studentId) {
		logger.info("Start getStudent. ID="+studentId);
		
		return studentData.get(studentId);
	}
	
	/**
	 * @return list of all students
	 */
	@RequestMapping(value = StudentConstants.GET_ALL_STUDENT, method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudents() {
		logger.info("Start getAllStudents.");
		List<Student> students = new ArrayList<Student>();
		Set<String> studentIdKeys = studentData.keySet();
		Iterator<String> iter =  studentIdKeys.iterator();
		while(iter.hasNext()){
			students.add(studentData.get(iter.next()));
		}
		return students;
	}
	
	/**
	 * @param student
	 * @return the created student value
	 */
	@RequestMapping(value = StudentConstants.CREATE_STUDENT, method = RequestMethod.POST)
	public @ResponseBody Student createStudent(@RequestBody Student student) {
		logger.info("Start createStudent.");
		
		studentData.put(student.getStudentNumber(), student);
		return student;
	}
	
	/**
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = StudentConstants.DELETE_STUDENT, method = RequestMethod.PUT)
	public @ResponseBody Student deleteStudent(@PathVariable("id") String studentId) {
		logger.info("Start deleteStudent.");
		Student emp = studentData.get(studentId);
		studentData.remove(studentId);
		return emp;
	}
	
}
