package com.HMS.hospital_mgmt.repository;

import com.HMS.hospital_mgmt.dto.AvailableAppointment;
import com.HMS.hospital_mgmt.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime start, LocalDateTime end);

    Appointment findByDoctorIdAndAppointmentDateTime(int doctorId,LocalDateTime appointmentDateTime);
}
