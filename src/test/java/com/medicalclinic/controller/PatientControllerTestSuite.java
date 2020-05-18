package com.medicalclinic.controller;

import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.PatientDto;
import com.medicalclinic.domain.entity.Patient;
import com.medicalclinic.mapper.PatientMapper;
import com.medicalclinic.serivce.PatientService;
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
@WebMvcTest(PatientController.class)
public class PatientControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientMapper patientMapper;

    @MockBean
    private PatientService patientService;

    @Test
    public void shouldGetAllPatients() throws Exception {
        // Given
        List<Patient> patientList = new ArrayList<>();
        patientList.add(FixedVariables.RACHEL_GREEN);
        patientList.add(FixedVariables.MONICA_GELLER);
        patientList.add(FixedVariables.PHOEBE_BUFFAY);
        patientList.add(FixedVariables.JOEY_TRIBBIANI);
        patientList.add(FixedVariables.CHANDLER_BING);
        patientList.add(FixedVariables.ROSS_GELLER);

        List<PatientDto> patientDtoList = new ArrayList<>();
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.RACHEL_GREEN));
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.MONICA_GELLER));
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.PHOEBE_BUFFAY));
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.JOEY_TRIBBIANI));
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.CHANDLER_BING));
        patientDtoList.add(patientMapper.mapToPatientDto(FixedVariables.ROSS_GELLER));

        when(patientService.getAllPatients()).thenReturn(patientList);
        when(patientMapper.mapToPatientDtoList(any())).thenReturn(patientDtoList);

        // When & Then
        mockMvc.perform(get("/patients").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)));
    }

}