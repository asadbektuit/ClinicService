package com.example.exam.service;

import com.example.exam.dto.DoctorDto;
import com.example.exam.model.Doctor;
import com.example.exam.repository.DoctorRepository;
import com.example.exam.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorDto get(Integer id) {
        Doctor doctor = getEntity(id);
        DoctorDto dto = new DoctorDto();
        dto.setName(doctor.getName());
        dto.setSurname(doctor.getSurname());
        dto.setContact(doctor.getContact());
        dto.setDirection(doctor.getDirection());
        dto.setExperience(doctor.getExperience());
        return dto;
    }

    public DoctorDto create(DoctorDto dto) {
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSurname(dto.getSurname());
        doctor.setContact(dto.getContact());
        doctor.setDirection(dto.getDirection());
        doctor.setExperience(dto.getExperience());
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return dto;
    }


    public boolean update(Integer id, DoctorDto doctor) {
        Doctor update = getEntity(id);
        update.setName(doctor.getName());
        update.setSurname(doctor.getSurname());
        update.setContact(doctor.getContact());
        update.setDirection(doctor.getDirection());
        update.setExperience(doctor.getExperience());
        update.setUpdatedAt(LocalDateTime.now());
        doctorRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Doctor doctor = getEntity(id);
        doctor.setDeletedAt(LocalDateTime.now());
        doctorRepository.save(doctor);
        return true;
    }

    public Doctor getEntity(Integer id){
        Optional<Doctor> optional = doctorRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Doctor not found");
        }
        return optional.get();
    }
}
