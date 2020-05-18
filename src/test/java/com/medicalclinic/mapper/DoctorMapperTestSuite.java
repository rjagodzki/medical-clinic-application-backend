package com.medicalclinic.mapper;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.DoctorDto;
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
public class DoctorMapperTestSuite {
    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    public void mapToDoctorTest() {
        // Given
        DoctorDto doctorDto = new DoctorDto(1L,"FirstName", "LastName","Specialization", "Phone Number", "email@mail.com");

        // When
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);

        // Then
        assertEquals(doctorDto.getFirstName(), doctor.getFirstName());
        assertEquals(doctorDto.getLastName(), doctor.getLastName());
        assertEquals(doctorDto.getSpecialization(), doctor.getSpecialization());
        assertEquals(doctorDto.getPhoneNumber(), doctor.getPhoneNumber());
        assertEquals(doctorDto.getEmailAddress(), doctor.getEmailAddress());
    }

    @Test
    public void mapToDoctorDtoTest() {
        // Given
        Doctor doctor = FixedVariables.LILY_ALDRIN;

        // When
        DoctorDto doctorDto = doctorMapper.mapToDoctorDto(doctor);

        // Then
        assertEquals(doctor.getFirstName(), doctorDto.getFirstName());
        assertEquals(doctor.getLastName(), doctorDto.getLastName());
        assertEquals(doctor.getSpecialization(), doctorDto.getSpecialization());
        assertEquals(doctor.getPhoneNumber(), doctorDto.getPhoneNumber());
        assertEquals(doctor.getEmailAddress(), doctorDto.getEmailAddress());
    }

    @Test
    public void mapToDoctorDtoListTest() {
        // Given
        FixedVariables fixedVariables = new FixedVariables();
        List<Doctor> doctorList = fixedVariables.getDoctorList();

        // When
        List<DoctorDto> doctorDtoList = doctorMapper.mapToDoctorDtoList(doctorList);

        // Then
        assertEquals(doctorList.size(), doctorDtoList.size());
        assertEquals(doctorList.get(1).getFirstName(), doctorDtoList.get(1).getFirstName());
    }

}