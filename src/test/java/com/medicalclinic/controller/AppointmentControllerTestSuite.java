package com.medicalclinic.controller;

import com.google.gson.Gson;
import com.medicalclinic.FixedVariables;
import com.medicalclinic.domain.dto.AppointmentDto;
import com.medicalclinic.domain.entity.Appointment;
import com.medicalclinic.mapper.AppointmentMapper;
import com.medicalclinic.serivce.AppointmentService;
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
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentMapper appointmentMapper;

    @MockBean
    private AppointmentService appointmentService;

    @Test
    public void shouldGetAllAppointments() throws Exception {
        // Given
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        when(appointmentMapper.mapToAppointmentDtoList(appointmentService.getAllAppointments())).thenReturn(appointmentDtoList);

        // When & Then
        mockMvc.perform(get("/appointments").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }


}