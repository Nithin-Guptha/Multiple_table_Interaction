package com.emp.response;

import java.util.List;

import com.emp.entiry.Department;
import com.emp.entiry.EmpDetails;
import com.emp.entiry.Qualification;

public class EmpResponse {

//	private EmpDetails empDetails;
	private int empId;
	private String empName;
	private int age;
	private String gender;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	private Department department;
	private List<Qualification> qualification;

//	public EmpDetails getEmpDetails() {
//		return empDetails;
//	}
//
//	public void setEmpDetails(EmpDetails empDetails) {
//		this.empDetails = empDetails;
//	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}
}
