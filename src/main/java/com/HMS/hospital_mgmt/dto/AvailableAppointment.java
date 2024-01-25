package com.HMS.hospital_mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableAppointment {
    private String doctorName;
    private String specialization;
    private LocalDateTime timing;

    // constructors, getters, and setters
}