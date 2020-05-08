package com.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PatientDto {
    private Long patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Boolean active;
}
// TODO: Zgodność z Patient.java