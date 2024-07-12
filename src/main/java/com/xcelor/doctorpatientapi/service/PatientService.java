package com.xcelor.service;

import com.xcelor.entity.Patient;
import com.xcelor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PatientService {

        @Autowired
        private PatientRepository patientRepository;

        public Patient addPatient(Patient patient) {
                return patientRepository.save(patient);
        }

        public void removePatient(Long id) {
                if (!patientRepository.existsById(id)) {
                        throw new EntityNotFoundException("Patient not found");
                }
                patientRepository.deleteById(id);
        }

        public Patient getPatientById(Long id) {
                return patientRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        }
}
