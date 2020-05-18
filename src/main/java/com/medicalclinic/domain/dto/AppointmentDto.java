package com.medicalclinic.domain.dto;

import com.medicalclinic.domain.entity.Doctor;
import com.medicalclinic.domain.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AppointmentDto {
    private Long appointmentId;
    private AppointmentType appointmentType;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private LocalDate createdDate;
    private LocalTime createdTime;
    private Patient patient;
    private Doctor doctor;
}

