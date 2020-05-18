package com.medicalclinic.domain.dto;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.mapper.AppointmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppointmentDtoTestSuite {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    public void createAppointmentDtoTest() {
        // Given
        AppointmentDto appointmentDto = appointmentMapper.mapToAppointmentDto(FixedVariables.SAMPLE_APPOINTMENT_ONE);


        // When & Then
        assertEquals(1L, appointmentDto.getAppointmentId());
        assertEquals(AppointmentType.BLOOD_TEST, appointmentDto.getAppointmentType());
        assertEquals(LocalDate.of(2010,10,10), appointmentDto.getAppointmentDate());
        assertEquals(LocalTime.of(10,10), appointmentDto.getAppointmentTime());
        assertEquals(LocalDate.now(), appointmentDto.getCreatedDate());
        assertEquals(LocalTime.now().getHour(), appointmentDto.getCreatedTime().getHour());
        assertEquals(FixedVariables.PHOEBE_BUFFAY, appointmentDto.getPatient());
        assertEquals(FixedVariables.BARNEY_STINSON, appointmentDto.getDoctor());
    }

}