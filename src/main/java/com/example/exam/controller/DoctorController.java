package com.example.exam.controller;

import com.example.exam.dto.DoctorDto;
import com.example.exam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//salom asadbek
//salom bro

//nma gap?
//bewim sila



//8559
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        DoctorDto result = doctorService.get(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DoctorDto doctor){
        DoctorDto result = doctorService.create(doctor);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid DoctorDto doctor){
        boolean result = doctorService.update(id,doctor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = doctorService.delete(id);
        return ResponseEntity.ok(result);
    }

}
