package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.Patient;

import java.util.List;

public interface PatientService {
    public PatientDto createPatient(PatientDto patienDto);
    public PatientDto updatePatient(PatientDto patientDto, int patientId);
    public void deletePatient(int id);

    public Patient getPatientById(int id);


}
