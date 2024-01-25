package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.DoctorAvailability;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DoctorAvailabilityService {
    public Optional<DoctorAvailability> findAvailabilityByDoctorIdAndDate(int doctorId, LocalDateTime availableTime);

    List<DoctorAvailability> findByDoctorIdAndAppointmentDateTimeBetween(int doctor, LocalDateTime start, LocalDateTime end);
}
