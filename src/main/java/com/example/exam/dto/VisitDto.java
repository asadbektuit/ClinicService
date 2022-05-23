package com.example.exam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitDto {
    private Integer id;
    private PatientDto patient;
    private Integer patientId;
    private DoctorDto doctor;
    private Integer doctorId;
    @NotBlank(message = ("Tashxis qoyilmagan"))
    private String diagnosis;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
