package com.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DoctorDto {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;
    private String emailAddress;
}

