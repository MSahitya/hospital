package com.HMS.hospital_mgmt.controller;

import com.HMS.hospital_mgmt.dto.PatientDto;
import com.HMS.hospital_mgmt.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPBinding;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

PatientService patientService;
public   PatientController(PatientService patientService){
    this.patientService=patientService;
}

   /* @GetMapping("/search")
    public ResponseEntity<PatientDto> searchPatient(@RequestParam int id, @RequestParam String first_name, @RequestParam String last_name){
        return null;
    }
    @GetMapping("/")
    public ResponseEntity<PatientDto> getAllPatients(@RequestParam int id,
                                                     @RequestParam String first_name,
                                                     @RequestParam String last_name){
        return ResponseEntity.ok(patientService.)
    }*/

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
      System.out.println(patientDto.toString());
      return ResponseEntity.ok(patientService.createPatient(patientDto)); //ResponseEntity<>(patientDto, HttpStatus.OK)
  }

@PutMapping("{patientId}/update")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto,
                                    @PathVariable("patientId") int patientId){
PatientDto patientResponse=patientService.updatePatient(patientDto,patientId);
return ResponseEntity.ok(patientResponse);
}

@DeleteMapping("{patientId}/delete")
public ResponseEntity<String> deletePatient(@PathVariable("patientId") int patientId){

      patientService.deletePatient(patientId);
      return ResponseEntity.ok("Patient Record Deleted successfully");



}
}
