package com.springBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootProject.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long>{
    
}
