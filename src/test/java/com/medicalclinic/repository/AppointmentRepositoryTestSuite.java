package com.medicalclinic.repository;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.entity.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentRepositoryTestSuite {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    public void repositoryTest() {
        // Given
        Appointment appointment = FixedVariables.SAMPLE_APPOINTMENT_ONE;
        Appointment appointment2 = FixedVariables.SAMPLE_APPOINTMENT_TWO;

        // When
        appointmentRepository.save(appointment);
        appointmentRepository.save(appointment2);
        List<Appointment> appointments = appointmentRepository.findAll();

        // Then
        assertEquals(2, appointments.size());
    }
}