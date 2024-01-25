package com.HMS.hospital_mgmt.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class DoctorNotFoundException extends RuntimeException {
    String doctorName;

    String specialization;

    public String getDoctorName() {
        return doctorName;
    }



    public DoctorNotFoundException(String doctorName, String specialization) {
        super(String.format("%s not found at %s",doctorName, specialization));
        this.doctorName=doctorName;
        this.specialization=specialization;
    }
}
