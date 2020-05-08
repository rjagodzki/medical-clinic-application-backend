package com.medicalclinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MedicalExaminationDto {
    private Long medicalExaminationId;
    private LocalDateTime createdDate;
    private LocalDateTime examinationDate;
}

// TODO: Zgodność z MedicalExamination.java
