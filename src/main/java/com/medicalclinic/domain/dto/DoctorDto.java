package com.medicalclinic.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorDto {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;
    private String emailAddress;
}

// TODO: Zgodność z Doctor.java
