package com.xcelor.controller;

import com.xcelor.entity.Doctor;
import com.xcelor.entity.Patient;
import com.xcelor.service.DoctorService;
import com.xcelor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/suggest-doctors")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        List<Doctor> doctors = doctorService.suggestDoctors(patient.getCity(), patient.getSymptom());
        if (doctors.isEmpty()) {
            if (patient.getCity().equals("Delhi") || patient.getCity().equals("Noida") || patient.getCity().equals("Faridabad")) {
                return ResponseEntity.ok("No doctors available for the given city and symptom.");
            } else {
                return ResponseEntity.ok("No doctors available for the given city and symptom. Please visit a metro city.");
            }
        }
        return ResponseEntity.ok(doctors);
    }
}