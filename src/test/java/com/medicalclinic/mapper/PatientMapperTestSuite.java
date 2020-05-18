package com.medicalclinic.mapper;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.PatientDto;
import com.medicalclinic.domain.entity.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientMapperTestSuite {
    @Autowired
    private PatientMapper patientMapper;

    @Test
    public void mapToPatientTest() {
        // Given
        PatientDto patientDto = new PatientDto(1L,"Ben", "Geller", LocalDate.of(1995, 5,11),"New York","111111111","ben.geller@friends.com","Ross Geller", true);

        // When
        Patient patient = patientMapper.mapToPatient(patientDto);

        // Then
        assertEquals(patient.getPatientId(), patientDto.getPatientId());
        assertEquals(patient.getFirstName(), patientDto.getFirstName());
        assertEquals(patient.getLastName(), patientDto.getLastName());
        assertEquals(patient.getDateOfBirth(), patientDto.getDateOfBirth());
        assertEquals(patient.getPlaceOfBirth(), patientDto.getPlaceOfBirth());
        assertEquals(patient.getPhoneNumber(), patientDto.getPhoneNumber());
        assertEquals(patient.getEmailAddress(), patientDto.getEmailAddress());
        assertEquals(patient.getAuthorizedPerson(), patientDto.getAuthorizedPerson());
        assertEquals(patient.getActive(), patientDto.getActive());
    }

    @Test
    public void mapToPatientDtoTest() {
        // Given
        Patient patient = FixedVariables.ROSS_GELLER;

        // When
        PatientDto patientDto = patientMapper.mapToPatientDto(patient);

        // Then
        assertEquals(patientDto.getPatientId(), patient.getPatientId());
        assertEquals(patientDto.getFirstName(), patient.getFirstName());
        assertEquals(patientDto.getLastName(), patient.getLastName());
        assertEquals(patientDto.getDateOfBirth(), patient.getDateOfBirth());
        assertEquals(patientDto.getPlaceOfBirth(), patient.getPlaceOfBirth());
        assertEquals(patientDto.getPhoneNumber(), patient.getPhoneNumber());
        assertEquals(patientDto.getEmailAddress(), patient.getEmailAddress());
        assertEquals(patientDto.getAuthorizedPerson(), patient.getAuthorizedPerson());
        assertEquals(patientDto.getActive(), patient.getActive());
    }

    @Test
    public void mapToPatientDtoListTest() {
        // Given
        FixedVariables fixedVariables = new FixedVariables();
        List<Patient> patientList = fixedVariables.getPatientList();

        // When
        List<PatientDto> patientDtoList = patientMapper.mapToPatientDtoList(patientList);

        // Then
        assertEquals(patientDtoList.size(), patientList.size());
        assertEquals(patientDtoList.get(3).getFirstName(), patientList.get(3).getFirstName());
    }
}