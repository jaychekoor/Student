package com.jayasree.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.jayasree.spring.controller.StudentConstants;
import com.jayasree.spring.model.Student;

public class TestStudentExample {

	public static final String SERVER_URI = "http://localhost:9090/Student";
	
	public static void main(String args[]){
		
		testGetDummyStudent();		
		testCreateStudent();		
		testGetStudent();		
		testGetAllStudents();
	}

	private static void testGetDummyStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(SERVER_URI+StudentConstants.DUMMY_STUDENT, Student.class);
		printStudentpData(student);
	}
	
	private static void testCreateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = new Student();
		student.setId(1);student.setFirstName("Pankaj Kumar");
		Student response = restTemplate.postForObject(SERVER_URI+StudentConstants.CREATE_STUDENT, student, Student.class);
		printStudentpData(response);
	}
	
	private static void testGetAllStudents() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+StudentConstants.GET_ALL_STUDENT, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	

	private static void testGetStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Student.class);
		printStudentpData(student);
	}

	
	
	public static void printStudentpData(Student student){
		System.out.println("ID="+student.getId()+",Name="+student.getFirstName());
	}
}
