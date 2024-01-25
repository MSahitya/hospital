package com.HMS.hospital_mgmt.controller;

import com.HMS.hospital_mgmt.dto.AvailableAppointment;
import com.HMS.hospital_mgmt.dto.DoctorDto;
import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.exceptions.ResourceNotFoundException;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.Patient;
import com.HMS.hospital_mgmt.service.AppointmentService;
import com.HMS.hospital_mgmt.service.DoctorService;
import com.HMS.hospital_mgmt.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

   @GetMapping("/available")
    public ResponseEntity<List<AvailableAppointment>> getAvailableAppointments(
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date,
            @RequestParam("doctorId") int doctorId) {
        // Parse the date string into a LocalDate
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        LocalDateTime localDateTime = localDate.atTime(LocalTime.MIDNIGHT);
        List<AvailableAppointment> availableAppointments = appointmentService.getAvailableAppointments(localDateTime, doctorId);
        return ResponseEntity.ok(availableAppointments);
    }

    @GetMapping("/book")
    public ResponseEntity<String> bookAppointment(
            @RequestParam("doctorId") int doctorId,
            @RequestParam("patientId")  int patientId,
            @RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime appointmentDateTime) {

        Doctor doctor = doctorService.getDoctorById(doctorId) ;
        Patient patient = patientService.getPatientById(patientId);
        DoctorDto doctorDto=new DoctorDto();doctorDto.setId(doctorId);
        PatientDto patientDto=new PatientDto();patientDto.setId(patientId);
        boolean isAppointmentBooked = appointmentService.bookAppointment(doctorId, patientId, appointmentDateTime);

        if (isAppointmentBooked) {
            return ResponseEntity.ok("Appointment booked successfully");
        } else {
            return ResponseEntity.badRequest().body("Doctor is not available at the specified time or Please enter Proper Values and Try again");
        }
    }


}