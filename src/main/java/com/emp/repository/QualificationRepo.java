package com.emp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entiry.Qualification;


@Repository
public interface QualificationRepo extends JpaRepository<Qualification, Integer>{

	List<Optional<Qualification>> findByemployeeId(int empId);
}
