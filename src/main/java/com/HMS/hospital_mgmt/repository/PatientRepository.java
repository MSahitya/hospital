package com.HMS.hospital_mgmt.repository;


import com.HMS.hospital_mgmt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
