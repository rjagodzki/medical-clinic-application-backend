package com.medicalclinic.domain.entity;

import com.medicalclinic.FixedVariables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorTestSuite {
    @Test
    public void createDoctorTest() {
        // Given
        Doctor doctor = FixedVariables.ROBIN_SCHERBASTSKY;

        // When & Then
        assertEquals("Robin", doctor.getFirstName());
        assertEquals("Scherbatsky", doctor.getLastName());
        assertEquals("Psychologist", doctor.getSpecialization());
        assertEquals("456123789", doctor.getPhoneNumber());
        assertEquals("robin.scherbatsky@himym.com", doctor.getEmailAddress());
    }
}