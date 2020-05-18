package com.medicalclinic.domain.dto;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.mapper.DoctorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorDtoTestSuite {
    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    public void createDoctorDtoTest() {
        // Given
        DoctorDto doctorDto = doctorMapper.mapToDoctorDto(FixedVariables.TED_MOSBY);

        // When & Then
        assertEquals("Ted", doctorDto.getFirstName());
        assertEquals("Mosby", doctorDto.getLastName());
        assertEquals("Dermatologist", doctorDto.getSpecialization());
        assertEquals("441234657", doctorDto.getPhoneNumber());
        assertEquals("ted.mosby@himym.com", doctorDto.getEmailAddress());
    }
}