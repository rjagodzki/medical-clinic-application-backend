package com.medicalclinic.domain.dto;

import com.medicalclinic.domain.entity.Doctor;
import com.medicalclinic.domain.entity.Patient;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AppointmentDto {
    private Long appointmentId;
    private AppointmentType appointmentType;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Patient patientDto;
    private Doctor doctorDto;
    private LocalDate createdDate;
    private LocalTime createdTime;
}
// TODO: Zgodność z Appointment.java.
