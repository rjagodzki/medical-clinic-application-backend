package com.medicalclinic.domain.entity;

import com.fasterxml.jackson.annotation.*;
import com.medicalclinic.domain.dto.AppointmentType;
import com.medicalclinic.domain.dto.DoctorDto;
import com.medicalclinic.domain.dto.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(value = {"createdDate", "createdTime"}, allowGetters = true)
@Entity(name = "APPOINTMENTS")
public class Appointment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_ID", unique = true)
    private Long appointmentId;

    @Column(name = "APPOINTMENT_TYPE")
    private AppointmentType appointmentType;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "APPOINTMENT_DATE")
    private LocalDate appointmentDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    private LocalTime appointmentTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    @Column(name = "CREATED_TIME")
    private LocalTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT")
    public Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR")
    public Doctor doctor;

    @PrePersist
    void setCreatedDateAndTime() {
        this.createdDate = LocalDate.now();
        this.createdTime = LocalTime.now();
    }

}
