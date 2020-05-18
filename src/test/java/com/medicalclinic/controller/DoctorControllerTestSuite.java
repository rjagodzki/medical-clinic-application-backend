package com.medicalclinic.controller;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.DoctorDto;
import com.medicalclinic.domain.entity.Doctor;
import com.medicalclinic.mapper.DoctorMapper;
import com.medicalclinic.serivce.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    @MockBean
    private DoctorMapper doctorMapper;

    @Test
    public void shouldGetAllDoctors() throws Exception {
        // Given
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(FixedVariables.ROBIN_SCHERBASTSKY);
        doctorList.add(FixedVariables.TED_MOSBY);
        doctorList.add(FixedVariables.BARNEY_STINSON);
        doctorList.add(FixedVariables.LILY_ALDRIN);
        doctorList.add(FixedVariables.MARSHALL_ERIKSEN);

        List<DoctorDto> doctorDtoList = new ArrayList<>();
        doctorDtoList.add(doctorMapper.mapToDoctorDto(FixedVariables.ROBIN_SCHERBASTSKY));
        doctorDtoList.add(doctorMapper.mapToDoctorDto(FixedVariables.TED_MOSBY));
        doctorDtoList.add(doctorMapper.mapToDoctorDto(FixedVariables.BARNEY_STINSON));
        doctorDtoList.add(doctorMapper.mapToDoctorDto(FixedVariables.LILY_ALDRIN));
        doctorDtoList.add(doctorMapper.mapToDoctorDto(FixedVariables.MARSHALL_ERIKSEN));

        when(doctorService.getAllDoctors()).thenReturn(doctorList);
        when(doctorMapper.mapToDoctorDtoList(any())).thenReturn(doctorDtoList);

        // When & Then
        mockMvc.perform(get("/doctors")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }
}