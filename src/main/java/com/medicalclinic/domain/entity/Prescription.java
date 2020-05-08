package com.medicalclinic.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRESCRIPTIONS")
public class Prescription {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRESCRIPTION_ID")
    private Long prescriptionId;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "EXPIRED_DATE")
    private LocalDate expiredDate;

//    @ManyToOne
//
//    public Patient patient;

    @NotNull
    @Column(name = "DRUG_ONE")
    private String drugOne;

    @NotNull
    @Column(name = "DOSAGE_OF_DRUG_ONE")
    private String dosageOfDrugOne;

    @Column(name = "DRUG_TWO")
    private String drugTwo;

    @Column(name = "DOSAGE_OF_DRUG_TWO")
    private String dosageOfDrugTwo;

    @Column(name = "DRUG_THREE")
    private String drugThree;

    @Column(name = "DOSAGE_OF_DRUG_THREE")
    private String dosageOfDrugThree;

    @Column(name = "DRUG_FOUR")
    private String drugFour;

    @Column(name = "DOSAGE_OF_DRUG_FOUR")
    private String dosageOfDrugFour;

    @Column(name = "DRUG_FIVE")
    private String drugFive;

    @Column(name = "DOSAGE_OF_DRUG_FIVE")
    private String dosageOfDrugFive;

    @PrePersist
    void setCreatedDate() {
        this.createdDate = LocalDate.now();
    }

    @PreUpdate
    void setExpiredDate() {
        this.expiredDate = createdDate.plusMonths(1);
    }

    // TODO: Relacje z pacjent i doktor
    // TODO: Sprawdź czy działa ta data
}
