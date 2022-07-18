package com.controller.model;

import org.springframework.stereotype.Component;

@Component
public class ProjectDetail {
	private String projectID;
	private String projectName;
	private String managerID;
	private int noOfEmploy;
	private String technology;
	
	public ProjectDetail() {
		super();
	}
	public ProjectDetail(String projectID, String projectName, String managerID, int noOfEmploy, String technology) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.managerID = managerID;
		this.noOfEmploy = noOfEmploy;
		this.technology = technology;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public int getNoOfEmploy() {
		return noOfEmploy;
	}
	public void setNoOfEmploy(int noOfEmploy) {
		this.noOfEmploy = noOfEmploy;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	

}
