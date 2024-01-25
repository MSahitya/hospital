package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.DoctorAvailability;
import com.HMS.hospital_mgmt.repository.DoctorAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorAvailabilityServiceImpl implements  DoctorAvailabilityService {

    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    public DoctorAvailabilityServiceImpl(DoctorAvailabilityRepository doctorAvailabilityRepository) {
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
    }

    public Optional<DoctorAvailability> findAvailabilityByDoctorIdAndDate(int doctorId, LocalDateTime availabilityDate) {
                    Date date = Date.from(availabilityDate.atZone(ZoneId.systemDefault()).toInstant());

        // Convert Date to LocalDateTime
       // Instant instant = date.toInstant();
        //LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
               return doctorAvailabilityRepository.findByDoctorIdAndAvailabilityDate(doctorId, availabilityDate);

    }

    public List<DoctorAvailability> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime start, LocalDateTime end){
        return null;//doctorAvailabilityRepository.findByDoctorIdAndAppointmentDateTimeBetween(doctorId,start,end);
    }
}