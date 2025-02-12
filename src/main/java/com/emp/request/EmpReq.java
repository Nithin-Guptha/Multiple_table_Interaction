package com.emp.request;

import java.util.List;

public class EmpReq {

	private EmpDetailsReq empDetailsReq;
	private DepartmentReq departmentReq;
	private List<QualificationReq> qualificationReq;
	
	public EmpDetailsReq getEmpDetailsReq() {
		return empDetailsReq;
	}
	public void setEmpDetailsReq(EmpDetailsReq empDetailsReq) {
		this.empDetailsReq = empDetailsReq;
	}
	public DepartmentReq getDepartmentReq() {
		return departmentReq;
	}
	public void setDepartmentReq(DepartmentReq departmentReq) {
		this.departmentReq = departmentReq;
	}
	public List<QualificationReq> getQualificationReq() {
		return qualificationReq;
	}
	public void setQualificationReq(List<QualificationReq> qualificationReq) {
		this.qualificationReq = qualificationReq;
	}
	
}
