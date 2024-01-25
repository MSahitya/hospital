package com.HMS.hospital_mgmt.service;


        import com.HMS.hospital_mgmt.dto.DoctorDto;
        import com.HMS.hospital_mgmt.model.Doctor;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

public interface DoctorService {
    List<Doctor> getdoctorByDepartmentId(int id);
    List<Doctor> getdoctorByDepartment(String dept);
    public List<DoctorDto> getAllDoctors(int pageNo,int pageSize);

    public Optional<Doctor> getDoctorWithDepartmentById(int doctorId) ;

    public Doctor getDoctorById(int id);
}