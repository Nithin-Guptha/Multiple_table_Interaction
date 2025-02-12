package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.request.DepartmentReq;
import com.emp.request.EmpReq;
import com.emp.response.EmpResponse;
import com.emp.response.Response;
import com.emp.service.EmpService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/insertData")
	public Response<String> insertData(@RequestBody EmpReq empReq) {
		return empService.insertData(empReq);
	}

	@GetMapping("/fetchData")
	public Response<List<EmpResponse>> fetchData() {
		return empService.getAllData();
	}
	
	@PutMapping("/updateDepartment")
	public String updateDepartment(@RequestBody DepartmentReq deptReq) {		
		return empService.updateDepartment(deptReq);
	}
//	@PostMapping("/DepartmentHistory")
//	public String DepartmentHistory(@RequestBody DepartmentReq departmentReq) {
//		//TODO: process POST request
//		
//		return empService.deptHistory();
//	}
	

}
