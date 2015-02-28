package com.jayasree.spring.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


/**
 * 
 * @author jayasree puthalath chekoor
 *
 */
public class Student implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private long id;
	private String studentNumber;
	private String gender;
	private String birthDate;
	private boolean disability;
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * 
	 * @param id 
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return Student Number
	 */
	public String getStudentNumber() {
		return studentNumber;
	}
	/**
	 * 
	 * @param studentNumber
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 
	 * @return date of birth
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * 
	 * @return disability status
	 */
	public boolean isDisability() {
		return disability;
	}
	/**
	 * 
	 * @param disability
	 */
	public void setDisability(boolean disability) {
		this.disability = disability;
	}
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
