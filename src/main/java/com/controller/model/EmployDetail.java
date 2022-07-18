package com.controller.model;

import org.springframework.stereotype.Component;

@Component
public class EmployDetail {
	private String employID;
	private String employName;
	private int age;
	private String gender;
	private String indExp;
	private String salary;
	private String designation;
	
	public EmployDetail() {
		super();
	}
	public EmployDetail(String employID, String employName, int age, String gender, String indExp, String salary,
			String designation) {
		super();
		this.employID = employID;
		this.employName = employName;
		this.age = age;
		this.gender = gender;
		this.indExp = indExp;
		this.salary = salary;
		this.designation = designation;
	}
	public String getEmployID() {
		return employID;
	}
	public void setEmployID(String employID) {
		this.employID = employID;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIndExp() {
		return indExp;
	}
	public void setIndExp(String indExp) {
		this.indExp = indExp;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "EmployDetail [employID=" + employID + ", employName=" + employName + ", age=" + age + ", gender="
				+ gender + ", indExp=" + indExp + ", salary=" + salary + ", designation=" + designation + "]";
	}
	
	
	
}
