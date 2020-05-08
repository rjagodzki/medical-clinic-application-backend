package com.medicalclinic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "MEDICAL_EXAMINATIONS")
public class MedicalExamination {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEDICAL_EXAMINATION_ID")
    private Long medicalExaminationId;

    @Column(name = "CREATED_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddThh:mm:ss Z")
    private LocalDateTime createdDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddThh:mm:ss Z")
    @Column(name = "EXAMINATION_DATE")
    private LocalDateTime examinationDate;

    @PrePersist
    void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    // TODO: Relacje z doktor i pacjent
    // TODO: Sprawdź czy działa data
}
