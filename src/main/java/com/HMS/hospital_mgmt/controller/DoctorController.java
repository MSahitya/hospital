package com.HMS.hospital_mgmt.controller;

        import com.HMS.hospital_mgmt.dto.DoctorDto;
        import com.HMS.hospital_mgmt.model.Doctor;
        import com.HMS.hospital_mgmt.service.DoctorService;
        import com.HMS.hospital_mgmt.service.DoctorServiceImpl;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(@RequestParam("query") int query){

       List<Doctor> doctors=doctorService.getdoctorByDepartmentId(query);
        System.out.println("Query Parameter="+query+"\t list="+doctors+"\n size="+doctors.size());
        Doctor doc=new Doctor();
        if (doctors != null) {
            return ResponseEntity.ok(doctors);
        } else {
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok();

    }
    @GetMapping("/searchBy")
    public ResponseEntity<List<Doctor>> searchDoctorsBySpecialization(@RequestParam("specialization") String query){

        List<Doctor> doctors=doctorService.getdoctorByDepartment(query);
        System.out.println("Query Parameter="+query+"\t list="+doctors+"\n size="+doctors.size());
        Doctor doc=new Doctor();
        if (doctors != null) {
            return ResponseEntity.ok(doctors);
        } else {
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok();

    }

/*@GetMapping("/getAll")
    public List<DoctorDto> getAllDoctors(){
        return doctorService.getAllDoctors();
    }*/
    @GetMapping("/getAll")
    public List<DoctorDto> getAllDoctors(
            @RequestParam(value = "pageNo", defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10" , required = false) int pageSize
    ){
        return doctorService.getAllDoctors(pageNo, pageSize);
    }


}