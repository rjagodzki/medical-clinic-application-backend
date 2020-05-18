package com.medicalclinic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity(name = "PATIENTS")
public class Patient {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PATIENT_ID", unique = true)
    private Long patientId;

    @NonNull
    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NonNull
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NonNull
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @NonNull
    @NotNull
    @Column(name = "PLACE_OF_BIRTH")
    private String placeOfBirth;

    @NonNull
    @NotNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NonNull
    @NotNull
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @NonNull
    @NotNull
    @Column(name = "AUTHORIZED_PERSON")
    private String authorizedPerson;

    @NonNull
    @NotNull
    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(
            targetEntity = Appointment.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Appointment> patientAppointments = new ArrayList<>();

    public Patient(Long patientId, String firstName, String lastName, LocalDate dateOfBirth, String placeOfBirth, String phoneNumber, String emailAddress, String authorizedPerson, Boolean active) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.authorizedPerson = authorizedPerson;
        this.active = active;
    }


    @PrePersist
    public void setActive() {
        this.active = true;
    }


}
