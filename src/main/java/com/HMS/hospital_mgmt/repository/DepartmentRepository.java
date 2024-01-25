package com.HMS.hospital_mgmt.repository;

import com.HMS.hospital_mgmt.model.Department;
import com.HMS.hospital_mgmt.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {


}
