package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.model.EmpProMap;
import com.controller.model.EmployDetail;
import com.controller.model.ProjectDetail;
import com.controller.service.CompanyRepo;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employ/rest")
public class EmpInfo {

	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	EmpProMap empProMap;
	
	@PostMapping(value = "/insertEmp", consumes = "application/json", produces="application/json")
	public List<EmployDetail> empInsert(@RequestBody EmployDetail employDetail) {
		if( companyRepo.insertEmp(employDetail)==1) {
			return companyRepo.selectEmp();
		}else {
			return null;
		}
	}
	
	@PutMapping(value = "/updateEmp", consumes = "application/json", produces="application/json")
	public List<EmployDetail> empUpdate(@RequestBody EmployDetail employDetail) {
		if( companyRepo.updateEmp(employDetail)==1) {
			return companyRepo.selectEmp();
		}else {
			return null;
		}
		
	}
	
	@DeleteMapping(value = "/deleteEmp/{employID}", produces="application/json")
	public List<EmployDetail> empDelete(@PathVariable("employID") String employID) {
		if( companyRepo.deleteEmp(employID)==1) {
			return companyRepo.selectEmp();
		}else {
			return null;
		}
	}
	
	@GetMapping(value = "/selectEmp", produces="application/json")
	public List<EmployDetail> empSelect() {
		return companyRepo.selectEmp();
	}	
	//*********************************
	@PostMapping(value = "/insertProj", consumes = "application/json", produces="application/json")
	public List<ProjectDetail> projInsert(@RequestBody ProjectDetail projectDetail) {
		if(companyRepo.insertProj(projectDetail)==1) {
			empProMap.setEmployID(projectDetail.getManagerID());
			empProMap.setProjectID(projectDetail.getProjectID());
			companyRepo.insertMap(empProMap);
			return companyRepo.selectProj();
		}
		return null;
	}
	
	@PutMapping(value = "/updateProj", consumes = "application/json", produces="application/json")
	public List<ProjectDetail> projUpdate(@RequestBody ProjectDetail projectDetail) {
		if(companyRepo.updateProj(projectDetail)==1) {
			return companyRepo.selectProj();
		}
		return null;
	}
	
	@DeleteMapping(value = "/deleteProj/{projectID}", produces="application/json")
	public List<ProjectDetail> projDelete(@PathVariable("projectID") String projectID) {
		if(companyRepo.deleteProj(projectID)==1) {
			return companyRepo.selectProj();
		}
		return null;
	}
	
	@GetMapping(value = "/selectProj", produces="application/json")
	public List<ProjectDetail> projSelect() {
		return companyRepo.selectProj();
	}
	//**********************************
	@PostMapping(value = "/insertMapping", consumes = "application/json", produces="application/json")
	public List<EmpProMap> insertMapping(@RequestBody EmpProMap empProMap) {
		if(companyRepo.insertMap(empProMap)==1) {
			return companyRepo.selectMap();
		}
		return null;
	}
	
	@DeleteMapping(value = "/deleteMapping/{ID}", produces="application/json")
	public List<EmpProMap> deleteMapping(@PathVariable("ID") String ID) {
		if(companyRepo.deleteMap(ID)==1) {
			return companyRepo.selectMap();
		}
		return null;
	}
	
	@GetMapping(value = "/selectMapping", produces="application/json")
	public List<EmpProMap> selectMapping() {
		return companyRepo.selectMap();
	}
}