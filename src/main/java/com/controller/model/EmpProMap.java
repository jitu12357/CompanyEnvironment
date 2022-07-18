package com.controller.model;

import org.springframework.stereotype.Component;

@Component
public class EmpProMap {
	private int id;
	private String EmployID;
	private String ProjectID;
	
	public EmpProMap() {
		super();	
	}
	public EmpProMap(int id, String employID, String projectID) {
		super();
		this.id = id;
		EmployID = employID;
		ProjectID = projectID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployID() {
		return EmployID;
	}
	public void setEmployID(String employID) {
		EmployID = employID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	

}
