package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.dto.DoctorDto;
import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.exceptions.ResourceNotFoundException;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.Patient;
import com.HMS.hospital_mgmt.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements  PatientService{
   private PatientRepository patientRepository;

   public PatientServiceImpl(PatientRepository patientRepository){
       this.patientRepository=patientRepository;
   }
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
       Patient p=new Patient();
       p.setFirst_name(patientDto.getFirst_name());
       p.setLast_name(patientDto.getLast_name());
       p.setMobile(patientDto.getMobile());
       p.setAge(patientDto.getAge());
       p.setSex(patientDto.getSex());
       p.setAddress(patientDto.getAddress());
      Patient p1= patientRepository.save(p);


      PatientDto patientDto1=new PatientDto();
      patientDto1.setId(p1.getId());
      patientDto1.setAddress(p1.getAddress());
      patientDto1.setSex(p1.getSex());
      patientDto1.setMobile((p1.getMobile()));
      patientDto1.setFirst_name((p1.getFirst_name()));
      patientDto1.setLast_name((p1.getLast_name()));
      patientDto1.setAge(p1.getAge());

       return patientDto1;
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto,int patientId) {

       Patient p1=patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Post","id",String.valueOf(patientId)));
       p1.setId(patientId);
       p1.setMobile(patientDto.getMobile());
       p1.setAge(patientDto.getAge());
       p1.setLast_name(patientDto.getLast_name());
       p1.setFirst_name(patientDto.getFirst_name());
       p1.setAddress(patientDto.getAddress());
      Patient p2= patientRepository.save(p1);
      return mapToDto(p2);

    }

    private PatientDto mapToDto(Patient p2) {
       PatientDto dto=new PatientDto();
       dto.setId(p2.getId());
       dto.setSex(p2.getSex());
       dto.setAddress(p2.getAddress());
       dto.setMobile(p2.getMobile());
       dto.setLast_name(p2.getLast_name());
       dto.setFirst_name(p2.getFirst_name());
       dto.setAge(p2.getAge());
       return dto;
    }

    @Override
    public void deletePatient(int id) {
        Patient p=new Patient();
        p.setId(id);
        patientRepository.deleteById(p.getId());
    }

    @Override
    public Patient getPatientById(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        // Use orElseThrow to throw an exception if the patient is not found
        return optionalPatient.orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + id));

    }


}
