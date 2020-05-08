package com.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PrescriptionDto {
    private Long prescriptionId;
    private LocalDate createdDate;
    private LocalDate expiredDate;
    private String drugOne;
    private String dosageOfDrugOne;
    private String drugTwo;
    private String dosageOfDrugTwo;
    private String drugThree;
    private String dosageOfDrugThree;
    private String drugFour;
    private String dosageOfDrugFour;
    private String drugFive;
    private String dosageOfDrugFive;
}

// TODO: Zgodność z Prescription.java
