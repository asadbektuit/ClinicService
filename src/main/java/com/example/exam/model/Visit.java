package com.example.exam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("visits"))
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("patient_id"), updatable = false, insertable = false)
    private Patient patient;

    @Column(name = ("patient_id"))
    private Integer patientId;

    @ManyToOne
    @JoinColumn(name = ("doctor_id"), updatable = false, insertable = false)
    private Doctor doctor;

    @Column(name = ("doctor_id"))
    private Integer doctorId;

    private String diagnosis;

    private Boolean status;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
