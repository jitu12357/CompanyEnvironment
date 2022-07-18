package com.controller.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.controller.model.EmployDetail;

public class EmployRowMapper implements RowMapper<EmployDetail> {

    @Override
    public EmployDetail mapRow(ResultSet rs, int rowNum) throws SQLException {

    	EmployDetail empDetail = new EmployDetail();
    	empDetail.setEmployID(rs.getString("EmployID"));
    	empDetail.setEmployName(rs.getString("EmployName"));
        empDetail.setAge(rs.getInt("Age"));
        empDetail.setGender(rs.getString("gender"));
        empDetail.setIndExp(rs.getString("IndustryExprience"));
        empDetail.setSalary(rs.getString("Salary"));
        empDetail.setDesignation(rs.getString("Designation"));

        return empDetail;

    }
}