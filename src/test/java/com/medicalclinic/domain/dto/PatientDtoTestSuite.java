package com.medicalclinic.domain.dto;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.mapper.PatientMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientDtoTestSuite {
    @Autowired
    private PatientMapper patientMapper;

    @Test
    public void createPatientDto() {
        // Given
        PatientDto patientDto = patientMapper.mapToPatientDto(FixedVariables.PHOEBE_BUFFAY);

        // WHen & Then
        assertEquals("Phoebe", patientDto.getFirstName());
        assertEquals("Buffay", patientDto.getLastName());
        assertEquals(LocalDate.of(1966, 2, 16), patientDto.getDateOfBirth());
        assertEquals("New York", patientDto.getPlaceOfBirth());
        assertEquals("222123444", patientDto.getPhoneNumber());
        assertEquals("pheobe.buffay@friends.com", patientDto.getEmailAddress());
        assertEquals("Mike Hannigan", patientDto.getAuthorizedPerson());
        assertTrue(patientDto.getActive());

    }
}