package com.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entiry.Department;
import com.emp.entiry.DeptHistory;

@Repository
public interface DeptHistoryRepo extends JpaRepository<DeptHistory, Integer>{
	Optional<DeptHistory> findByemployeeId(int empId);
}
