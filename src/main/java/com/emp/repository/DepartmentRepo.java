package com.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entiry.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	Optional<Department> findByemployeeId(int empId);
}
