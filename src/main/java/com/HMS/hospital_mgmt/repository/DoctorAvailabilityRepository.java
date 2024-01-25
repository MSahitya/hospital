package com.HMS.hospital_mgmt.repository;

import com.HMS.hospital_mgmt.model.Doctor;
import com.HMS.hospital_mgmt.model.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Integer> {

   // Optional<DoctorAvailability> findByDoctorIdAndAvailabilityDate(int doctorId, Date availabilityDate);
    @Query("SELECT da FROM DoctorAvailability da WHERE da.doctorId = :doctorId AND da.availabilityDate = :availabilityDate")
    Optional<DoctorAvailability> findByDoctorIdAndAvailabilityDate(
            @Param("doctorId") int doctorId,
            @Param("availabilityDate") LocalDateTime availabilityDate);

}
