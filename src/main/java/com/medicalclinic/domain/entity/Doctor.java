package com.medicalclinic.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "DOCTORS")
public class Doctor {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCTOR_ID", unique = true)
    private Long doctorId;

    @NotNull
    @NonNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @NonNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @NonNull
    @Column(name = "SPECIALIZATION")
    private String specialization;

    @NotNull
    @NonNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NonNull
    @NotNull
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
}
