package com.example.exam.repository;

import com.example.exam.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findByIdAndDeletedAtIsNull(Integer id);
}
