package com.medicalclinic.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
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
    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(
            targetEntity = Appointment.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Appointment> patientAppointments = new ArrayList<>();

    @PrePersist
    public void setActive() {
        this.active = true;
    }

    // TODO: Pomyśl nad innymi polami: co zrobić z miejscem zamieszkania? czy stworzyć nową encje, do której dostęp będą mieli również lekarze i inni pracownicy?

    // TODO: Jakie relacje?

}
