package com.medicalclinic.domain.entity;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.AppointmentType;
import com.medicalclinic.repository.AppointmentRepository;
import com.medicalclinic.repository.DoctorRepository;
import com.medicalclinic.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointmentTest {
    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Test
    public void test() {
        // Given
        Patient patient = FixedVariables.CHANDLER_BING;
        Doctor doctor =FixedVariables.BARNEY_STINSON;
        patientRepository.save(patient);
        doctorRepository.save(doctor);
        Appointment appointment = new Appointment(1L, AppointmentType.BLOOD_TEST, LocalDate.now().plusDays(2), LocalTime.now(), patient, doctor, LocalDate.now(), LocalTime.now());
        Appointment appointment2 = new Appointment(1L, AppointmentType.EKG, LocalDate.now().plusDays(3), LocalTime.now(), patient, doctor, LocalDate.now(), LocalTime.now());
        Appointment appointment3 = new Appointment(1L, AppointmentType.INTERNAL_MEDICINE, LocalDate.now().plusDays(4), LocalTime.now(), patient, doctor, LocalDate.now(), LocalTime.now());

        // When
        appointmentRepository.save(appointment);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);

        // Then


    }
}