package com.medicalclinic.domain.entity;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.AppointmentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AppointmentTestSuite {
    @Test
    public void createAppointmentTest() {
        // Given
        Appointment appointment = FixedVariables.SAMPLE_APPOINTMENT_ONE;

        // When & Then
        assertEquals(1L, appointment.getAppointmentId());
        assertEquals(AppointmentType.BLOOD_TEST, appointment.getAppointmentType());
        assertEquals(LocalDate.of(2010,10,10), appointment.getAppointmentDate());
        assertEquals(LocalTime.of(10,10), appointment.getAppointmentTime());
        assertEquals(LocalDate.now(), appointment.getCreatedDate());
        assertEquals(LocalTime.now().getHour(), appointment.getCreatedTime().getHour());
        assertEquals(FixedVariables.PHOEBE_BUFFAY, appointment.getPatient());
        assertEquals(FixedVariables.BARNEY_STINSON, appointment.getDoctor());
    }
}