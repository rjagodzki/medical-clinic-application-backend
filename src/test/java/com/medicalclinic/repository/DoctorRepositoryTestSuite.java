package com.medicalclinic.repository;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.entity.Doctor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorRepositoryTestSuite {
    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void repositoryTest() {
        // Given
        Doctor tedMosby = FixedVariables.TED_MOSBY;
        Doctor barneyStinson = FixedVariables.BARNEY_STINSON;

        // When
        doctorRepository.save(tedMosby);
        doctorRepository.save(barneyStinson);
        List<Doctor> doctors = doctorRepository.findAll();

        // Then
        assertEquals(2, doctors.size());
    }
}