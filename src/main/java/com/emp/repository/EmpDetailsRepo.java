package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entiry.EmpDetails;

@Repository
public interface EmpDetailsRepo extends JpaRepository<EmpDetails, Integer>{

}
