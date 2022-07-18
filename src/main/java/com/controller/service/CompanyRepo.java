package com.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.controller.model.EmpProMap;
import com.controller.model.EmployDetail;
import com.controller.model.ProjectDetail;

@Repository
public class CompanyRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// ************************* Insert Employ Details ***************************
	public Integer insertEmp(EmployDetail employDetail) {
		String query = "insert into EmpDetails (EmployID,EmployName,Age,gender,IndustryExprience,Salary,Designation) values (?,?,?,?,?,?,?)";

		return jdbcTemplate.update(query, employDetail.getEmployID(), employDetail.getEmployName(),
				employDetail.getAge(), employDetail.getGender(), employDetail.getIndExp(), employDetail.getSalary(),
				employDetail.getDesignation());
	}

	// ************************* Update Employ Details ***************************
	public Integer updateEmp(EmployDetail employDetail) {
		String query = "update EmpDetails set EmployName=?,Age=?,gender=?,IndustryExprience=?,Salary=?,Designation=? where EmployID=?";

		return jdbcTemplate.update(query, employDetail.getEmployName(), employDetail.getAge(), employDetail.getGender(),
				employDetail.getIndExp(), employDetail.getSalary(), employDetail.getDesignation(),
				employDetail.getEmployID());
	}

	// ************************* Delete Employ Details ***************************
	public Integer deleteEmp(String employID) {
		String query = "delete from EmpDetails where EmployID=?";

		return jdbcTemplate.update(query, employID);
	}

	// ************************* View Employ Details ***************************
	public List<EmployDetail> selectEmp() {
		String query = "select * from EmpDetails";

		return jdbcTemplate.query(query,
				(rs, rowNum) -> new EmployDetail(rs.getString("EmployID"), rs.getString("EmployName"), rs.getInt("Age"),
						rs.getString("gender"), rs.getString("IndustryExprience"), rs.getString("Salary"),
						rs.getString("Designation")));
	}

	// ************************* Insert Project Details ***************************
	public Integer insertProj(ProjectDetail projectDetail) {

		String query = "insert into ProjectTable (ProjectID,ProjectName,ManagerID,NoOFEmploy,Technology) values (?,?,?,?,?)";

		return jdbcTemplate.update(query, projectDetail.getProjectID(), projectDetail.getProjectName(),
				projectDetail.getManagerID(), projectDetail.getNoOfEmploy(), projectDetail.getTechnology());
	}

	// ************************* Update Project Details ***************************
	public Integer updateProj(ProjectDetail projectDetail) {
		String query = "update ProjectTable set ProjectName=?,ManagerID=?,NoOFEmploy=?,Technology=? where ProjectID=?";

		return jdbcTemplate.update(query, projectDetail.getProjectName(), projectDetail.getManagerID(),
				projectDetail.getNoOfEmploy(), projectDetail.getTechnology(), projectDetail.getProjectID());
	}

	// ************************* Delete Project Details ***************************
	public Integer deleteProj(String projectID) {
		String query = "delete from ProjectTable where ProjectID=?";

		return jdbcTemplate.update(query, projectID);
	}

	// ************************* View Project Details ***************************
	public List<ProjectDetail> selectProj() {
		String query = "select * from ProjectTable";

		return jdbcTemplate.query(query,
				(rs, rowNum) -> new ProjectDetail(rs.getString("ProjectID"), rs.getString("ProjectName"),
						rs.getString("ManagerID"), rs.getInt("NoOFEmploy"), rs.getString("Technology")));
	}

	// ************************* Insert Mapping Details ***************************
	public Integer insertMap(EmpProMap empProMap) {

		String query = "insert into ProjectEmpRelation (ProjectID,EmployID) values (?,?)";

		return jdbcTemplate.update(query, empProMap.getProjectID(), empProMap.getEmployID());
	}

	// ************************* Delete Mapping Details ***************************
	public Integer deleteMap(String id) {
		String query = "delete from ProjectEmpRelation where id=?";

		return jdbcTemplate.update(query, id);
	}

	// ************************* View Mapping Details ***************************
	public List<EmpProMap> selectMap() {
		String query = "select * from ProjectEmpRelation";

		return jdbcTemplate.query(query,
				(rs, rowNum) -> new EmpProMap(rs.getInt("id"), rs.getString("ProjectID"), rs.getString("EmployID")));
	}

}
