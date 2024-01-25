package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.dto.AvailableAppointment;
import com.HMS.hospital_mgmt.dto.DoctorDto;
import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.model.Appointment;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    //public List<AvailableAppointment> getAvailableAppointments(LocalDateTime date, int doctorId);
    public boolean bookAppointment(int doctor, int patient, LocalDateTime appointmentDateTime);


    List<AvailableAppointment> getAvailableAppointments(LocalDateTime localDateTime, int doctorId);
}
