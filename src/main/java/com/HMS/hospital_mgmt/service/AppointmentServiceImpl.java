package com.HMS.hospital_mgmt.service;

import com.HMS.hospital_mgmt.dto.AvailableAppointment;
import com.HMS.hospital_mgmt.dto.DoctorDto;
import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.exceptions.DoctorNotFoundException;
import com.HMS.hospital_mgmt.model.Appointment;
import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.DoctorAvailability;
import com.HMS.hospital_mgmt.model.Patient;
import com.HMS.hospital_mgmt.repository.AppointmentRepository;
import com.HMS.hospital_mgmt.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;





    public List<AvailableAppointment> getAvailableAppointments(LocalDateTime date, int doctorId)  {
         Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<DoctorAvailability> optionalDoctor= doctorAvailabilityService.findAvailabilityByDoctorIdAndDate(doctorId,date);

        if (optionalDoctor.isPresent()) {
            DoctorAvailability doctorAvailable = optionalDoctor.get();

            LocalDateTime startOfDay = doctorAvailable.getStartTime();//date.atStartOfDay();
            LocalDateTime endOfDay = doctorAvailable.getEndTime();//date.atTime(LocalTime.MAX);

            List<Appointment> existingAppointments = appointmentRepository
                    .findByDoctorIdAndAppointmentDateTimeBetween(doctor.get().getId(), startOfDay, endOfDay);

            // Assuming appointments are in 30-minute intervals
            List<LocalDateTime> availableTimings = calculateAvailableTimings(startOfDay, endOfDay, existingAppointments);
           //String specialization=  doctorRepository.findDoctorWithDepartmentById(doctorId);
            return availableTimings.stream()
                    .map(time -> new AvailableAppointment(doctor.get().getName(),"SPECIALIZATION" , time))
                    .collect(Collectors.toList());
        }

        throw new DoctorNotFoundException(String.valueOf(doctorId),"SPECIALIZATION");
    }

    public List<LocalDateTime> calculateAvailableTimings(LocalDateTime start, LocalDateTime end, List<Appointment> existingAppointments) {

        List<LocalDateTime> allTimings = new ArrayList<>();
        LocalDateTime current = start;

        while (!current.isAfter(end)) {
            allTimings.add(current);
            current = current.plusMinutes(30);
        }

        List<LocalDateTime> bookedTimings = existingAppointments.stream()
                .flatMap(appointment -> {
                    LocalDateTime startTime =LocalDateTime.now();// appointment.getStartTime();
                    LocalDateTime endTime = LocalDateTime.now();//appointment.getEndTime();
                    long intervalInMinutes = 30;

                    List<LocalDateTime> timings =  new ArrayList<>();
                    LocalDateTime currentTime = startTime;

                    while (currentTime.isBefore(endTime)) {
                        timings.add(currentTime);
                        currentTime = currentTime.plusMinutes(intervalInMinutes);
                    }

                    return timings.stream();
                })
                .collect(Collectors.toList());





        allTimings.removeAll(bookedTimings);

        return allTimings;
    }

    public boolean bookAppointment(int doctor, int patient, LocalDateTime appointmentDateTime) {
        // Check doctor availability
       Appointment existingAppointments = appointmentRepository.findByDoctorIdAndAppointmentDateTime(doctor, appointmentDateTime);

        if (null != existingAppointments) {
            return false;
        }
     Doctor doctor1=new Doctor();doctor1.setId(doctor);
     Patient patient1=new Patient();patient1.setId(patient);


        // Book the appointment
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor1);
        appointment.setPatient(patient1);
        appointment.setAppointmentDateTime(appointmentDateTime);

        appointmentRepository.save(appointment);

        return true;
    }
}