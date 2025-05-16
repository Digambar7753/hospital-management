package com.xcelore.backend.repository;

import com.xcelore.backend.entity.Doctor;
import com.xcelore.backend.entity.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}