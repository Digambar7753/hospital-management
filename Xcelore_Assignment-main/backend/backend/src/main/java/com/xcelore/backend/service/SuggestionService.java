package com.xcelore.backend.service;

import com.xcelore.backend.entity.Doctor;
import com.xcelore.backend.entity.Patient;
import com.xcelore.backend.entity.enums.Speciality;
import com.xcelore.backend.repository.DoctorRepository;
import com.xcelore.backend.repository.PatientRepository;
import com.xcelore.backend.util.SymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<?> suggestDoctors(Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        String city = patient.getCity();
        if (!List.of("Delhi", "Noida", "Faridabad").contains(city)) {
            return ResponseEntity.ok("We are still waiting to expand to your location");
        }

        Speciality speciality = SymptomMapper.mapSymptomToSpeciality(patient.getSymptom());
        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);

        if (doctors.isEmpty()) {
            return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
        }

        return ResponseEntity.ok(doctors);
    }
}
