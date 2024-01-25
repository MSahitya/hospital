package com.HMS.hospital_mgmt.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "doctor_availability")
public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id", nullable = false)
    private int doctorId;

    @Column(name = "availability_date", nullable = false)
    private LocalDateTime availabilityDate;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDateTime availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DoctorAvailability{" +
                "id=" + id +
                ", doctor=" + doctorId +
                ", availabilityDate=" + availabilityDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public DoctorAvailability() {
    }
}
