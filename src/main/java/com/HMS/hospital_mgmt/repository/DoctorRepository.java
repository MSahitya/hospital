package com.HMS.hospital_mgmt.repository;

import com.HMS.hospital_mgmt.model.Department;
import com.HMS.hospital_mgmt.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


    List<Doctor> findByDepartment(Department department);


    @Query("SELECT d, d.department FROM Doctor d WHERE d.department.name = :departmentName")
    List<Doctor> findDoctorsByDepartmentName(@Param("departmentName") String departmentName);


    @Query("SELECT d FROM Doctor d JOIN FETCH d.department WHERE d.id = :doctorId")
    Optional<Doctor> findDoctorWithDepartmentById(@Param("doctorId") int doctorId);
}
