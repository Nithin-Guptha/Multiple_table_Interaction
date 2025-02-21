package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entiry.Department;
import com.emp.entiry.DeptHistory;
import com.emp.entiry.EmpDetails;
import com.emp.entiry.Qualification;
import com.emp.repository.DepartmentRepo;
import com.emp.repository.DeptHistoryRepo;
import com.emp.repository.EmpDetailsRepo;
import com.emp.repository.QualificationRepo;
import com.emp.request.DepartmentReq;
import com.emp.request.EmpDetailsReq;
import com.emp.request.EmpReq;
import com.emp.request.QualificationReq;
import com.emp.response.EmpResponse;
import com.emp.response.Response;

@Service
public class EmpService {

	@Autowired
	private EmpDetailsRepo empDetailsRepo;

	@Autowired
	private QualificationRepo qualificationRepo;

	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private DeptHistoryRepo deptHistoryRepo;

	public Response<String> insertData(EmpReq empReq) {
		try {
			EmpDetailsReq empDetailReq = empReq.getEmpDetailsReq();
			EmpDetails empDetailsEntity = empDetailsMethod(empDetailReq);
			EmpDetails savedEmp = empDetailsRepo.save(empDetailsEntity);

			DepartmentReq departmentReq = empReq.getDepartmentReq();
			Department departmentEntity = departmentMethod(departmentReq, savedEmp.getEmpId());
			Department saveDept=departmentRepo.save(departmentEntity);

			
			
			List<QualificationReq> qualificationReqList = empReq.getQualificationReq();
			List<Qualification> qualificationEntities = qualificationMethod(qualificationReqList, savedEmp.getEmpId());
			qualificationRepo.saveAll(qualificationEntities);
			
			DepartmentReq deptHisReq = empReq.getDepartmentReq();
			DeptHistory deptHisEntity=deptHisMethod(deptHisReq,savedEmp.getEmpId());
			deptHistoryRepo.save(deptHisEntity);

			return new Response<>("SUCCESS", "Data inserted successfully", null);
		} catch (Exception e) {
			return new Response<>("FAILURE", "Error inserting data: " + e.getMessage(), null);
		}
	}

	public DeptHistory deptHisMethod(DepartmentReq deptHisReq, int empId) {
		DeptHistory dh=new DeptHistory();
		dh.setDept_id(deptHisReq.getDept_id());
		dh.setDept_name(deptHisReq.getDept_name());
		dh.setEmployeeId(empId);
		return dh;
	}


	public Response<List<EmpResponse>> getAllData() {
		try {
			List<EmpResponse> empRes = new ArrayList<>();
			List<EmpDetails> details = empDetailsRepo.findAll();

			for (EmpDetails dtl : details) {
				EmpResponse er = new EmpResponse();

				Department department = departmentRepo.findByemployeeId(dtl.getEmpId()).orElse(null);

				List<Optional<Qualification>> byEmpId = qualificationRepo.findByemployeeId(dtl.getEmpId());
				List<Qualification> qualify = new ArrayList<>();
				for (Optional<Qualification> oq : byEmpId) {
					Qualification qualifications=oq.get();
					qualify.add(qualifications);
				}

				er.setEmpId(dtl.getEmpId());
				er.setEmpName(dtl.getEmpName());
				er.setAge(dtl.getAge());
				er.setGender(dtl.getGender());
				er.setDepartment(department);
				er.setQualification(qualify);
				empRes.add(er);
			}
			return new Response<>("SUCCESS", "Data fetched successfully", empRes);
		} catch (Exception e) {
			return new Response<>("FAILURE", "Error fetching data: " + e.getMessage(), null);
		}
	}

	private EmpDetails empDetailsMethod(EmpDetailsReq empDetailReq) {
		EmpDetails ed = new EmpDetails();
		ed.setEmpName(empDetailReq.getEmpName());
		ed.setAge(empDetailReq.getAge());
		ed.setGender(empDetailReq.getGender());
		return ed;
	}

	private Department departmentMethod(DepartmentReq departmentReq, int empId) {
		Department department = new Department();
		department.setEmployeeId(empId);
		department.setDept_id(departmentReq.getDept_id());
		department.setDept_name(departmentReq.getDept_name());
		return department;
	}

	private List<Qualification> qualificationMethod(List<QualificationReq> qualificationReqList, int empId) {
		List<Qualification> qualifications = new ArrayList<>();
		for (QualificationReq qr : qualificationReqList) {
			Qualification qualification = new Qualification();
			qualification.setEmployeeId(empId);
			qualification.setEducation_type(qr.getEducation_type());
			qualification.setYear(qr.getYear());
			qualifications.add(qualification);
		}
		return qualifications;
	}

	
	public String updateDepartment(DepartmentReq deptReq) {
		Department dept=new Department();
		dept.setDept_id(deptReq.getDept_id());
		dept.setDept_name(deptReq.getDept_name());
		dept.setEmployeeId(deptReq.getEmployeeId());
		 departmentRepo.save(dept);
		 
		 DeptHistory depthistory= new  DeptHistory();
//		 depthistory.setDept_id(deptReq.getDept_id());
		 depthistory.setDept_name(deptReq.getDept_name());
		 depthistory.setEmployeeId(deptReq.getEmployeeId());
		 deptHistoryRepo.save(depthistory);
		 return "updated";
	}

	
}
