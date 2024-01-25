package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.dto.DepartmentDto;
import com.HMS.hospital_mgmt.dto.DoctorDto;
import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.exceptions.ResourceNotFoundException;
import com.HMS.hospital_mgmt.model.Department;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.repository.DepartmentRepository;
import com.HMS.hospital_mgmt.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DoctorServiceImpl implements  DoctorService{

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DepartmentRepository departmentRepository) {
        this.doctorRepository = doctorRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Doctor> getdoctorByDepartmentId(int deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Get Request","deptId",String.valueOf(deptId)));

        return doctorRepository.findByDepartment(department);
    }

    public List<Doctor> getdoctorByDepartment(String department) {

        List<Doctor> docs= doctorRepository.findDoctorsByDepartmentName(department);
       if(docs.isEmpty())
           throw new RuntimeException("No doctors found for Specialization: " + department);

        return docs ;

    }
    @Override
    public Optional<Doctor> getDoctorWithDepartmentById(int doctorId) {
        return doctorRepository.findDoctorWithDepartmentById(doctorId);
    }

    @Override
    public Doctor getDoctorById(int id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElseThrow(() -> new RuntimeException("Doctor not found with ID: "+String.valueOf(id)));
    }

    @Override
    public List<DoctorDto> getAllDoctors(int pageNo,int pageSize) {
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Doctor> doctorList=  doctorRepository.findAll(pageable);
        //get content
        List<Doctor> doctorDtoList1=doctorList.getContent();
        return  doctorDtoList1.stream().map(doctor -> mapToDto(doctor)).collect(Collectors.toList());
    }

    private DoctorDto mapToDto(Doctor doctor) {

        DoctorDto dto=new DoctorDto();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setMobile(doctor.getMobile());
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setId(doctor.getDepartment().getId());
        departmentDto.setName(doctor.getDepartment().getName());
        dto.setDepartment(departmentDto);
        dto.setLast_name(doctor.getLast_name());
        return dto;
    }
}
