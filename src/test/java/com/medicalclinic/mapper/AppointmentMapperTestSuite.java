package com.medicalclinic.mapper;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.AppointmentDto;
import com.medicalclinic.domain.dto.AppointmentType;
import com.medicalclinic.domain.entity.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppointmentMapperTestSuite {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    public void mapToAppointmentTest() {
        // Given
        AppointmentDto appointmentDto = new AppointmentDto(1L, AppointmentType.INTERNAL_MEDICINE, LocalDate.now().plusDays(1), LocalTime.now().plusHours(1), LocalDate.now(), LocalTime.now(), FixedVariables.ROSS_GELLER, FixedVariables.LILY_ALDRIN);

        // When
        Appointment appointment = appointmentMapper.mapToAppointment(appointmentDto);

        // Then
        assertEquals(appointmentDto.getAppointmentId(), appointment.getAppointmentId());
        assertEquals(appointmentDto.getAppointmentType(), appointment.getAppointmentType());
        assertEquals(appointmentDto.getAppointmentDate(), appointment.getAppointmentDate());
        assertEquals(appointmentDto.getAppointmentTime(), appointment.getAppointmentTime());
        assertEquals(appointmentDto.getCreatedDate(), appointment.getCreatedDate());
        assertEquals(appointmentDto.getCreatedTime(), appointment.getCreatedTime());
        assertEquals(appointmentDto.getPatient(), appointment.getPatient());
        assertEquals(appointmentDto.getDoctor(), appointment.getDoctor());
    }

    @Test
    public void mapToAppointmentDtoTest() {
        // Given
        Appointment appointment = FixedVariables.SAMPLE_APPOINTMENT_ONE;

        // When
        AppointmentDto appointmentDto = appointmentMapper.mapToAppointmentDto(appointment);

        // Then
        assertEquals(appointment.getAppointmentId(), appointmentDto.getAppointmentId());
        assertEquals(appointment.getAppointmentType(), appointmentDto.getAppointmentType());
        assertEquals(appointment.getAppointmentDate(), appointmentDto.getAppointmentDate());
        assertEquals(appointment.getAppointmentTime(), appointmentDto.getAppointmentTime());
        assertEquals(appointment.getCreatedDate(), appointmentDto.getCreatedDate());
        assertEquals(appointment.getCreatedTime(), appointmentDto.getCreatedTime());
        assertEquals(appointment.getPatient(), appointmentDto.getPatient());
        assertEquals(appointment.getDoctor(), appointmentDto.getDoctor());
    }

    @Test
    public void mapToAppointmentDtoListTest() {
        // Given
        FixedVariables fixedVariables = new FixedVariables();
        List<Appointment> appointmentList = fixedVariables.getAppointmentList();

        // When
        List<AppointmentDto> appointmentDtoList = appointmentMapper.mapToAppointmentDtoList(appointmentList);

        // Then
        assertEquals(appointmentDtoList.size(), appointmentList.size());
        assertEquals(appointmentDtoList.get(1).getCreatedTime(), appointmentList.get(1).getCreatedTime());
    }
}