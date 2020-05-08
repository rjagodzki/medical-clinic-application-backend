package com.medicalclinic.repository;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.entity.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTestSuite {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void repositoryTest() {
        // Given
        Patient chandlerBing = FixedVariables.CHANDLER_BING;
        Patient joeyTribbiani = FixedVariables.JOEY_TRIBBIANI;

        // When
        patientRepository.save(chandlerBing);
        patientRepository.save(joeyTribbiani);
        List<Patient> patients = patientRepository.findAll();

        // Then
        assertEquals(2, patients.size());


    }

}