package com.example.exam.repository;

import com.example.exam.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Optional<Patient> findByIdAndDeletedAtIsNull(Integer id);
}
