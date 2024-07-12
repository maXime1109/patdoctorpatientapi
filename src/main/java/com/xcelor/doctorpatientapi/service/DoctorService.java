package com.xcelor.service;

import com.xcelor.entity.Doctor;
import com.xcelor.repository.DoctorRepository;
import com.xcelor.util.SpecialityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        if (!SpecialityUtil.isValidSpeciality(doctor.getSpeciality())) {
            throw new IllegalArgumentException("Invalid speciality");
        }
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found");
        }
        doctorRepository.deleteById(id);
    }

    public List<Doctor> suggestDoctors(String city, String symptom) {
        String speciality = SpecialityUtil.getSpecialityBySymptom(symptom);
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }
}
