package com.medicalclinic.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// FIXME: Zmień nazwe klasy, nazwe encji i ewentualnie pola
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "persons")
public class AuthorizedPerson {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // FIXME: tutaj tez
    private Long Id; // FIXME: i tu

    @NotNull
    @Column(name = "FIRST_NAMES")
    private String firstNames;

    @NotNull
    @Column(name = "LAST_NAMES")
    private String lastName;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    // TODO: RELACJA Z PATIENT

    // FIXME: sdsa
}
