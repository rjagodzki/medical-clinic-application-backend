package com.medicalclinic.controller;

import com.medicalclinic.domain.dto.PatientDto;
import com.medicalclinic.mapper.PatientMapper;
import com.medicalclinic.serivce.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.medicalclinic.controller.NotFoundException.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    public List<PatientDto> getPatients() {
        return patientMapper.mapToPatientDtoList(patientService.getAllPatients());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patient")
    public PatientDto getPatient(@RequestParam Long patientId) throws NotFoundException {
        return patientMapper.mapToPatientDto(patientService.getPatient(patientId)
                .orElseThrow(() -> new NotFoundException(PATIENT_NOT_FOUND_EXCEPTION)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/patient", consumes = APPLICATION_JSON_VALUE)
    public void createPatient(@RequestBody PatientDto patientDto) {
        patientService.savePatient(patientMapper.mapToPatient(patientDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient")
    public PatientDto updatePatient(@RequestBody PatientDto patientDto) {
        return patientMapper.mapToPatientDto(patientService.savePatient(patientMapper.mapToPatient(patientDto)));
    }
}
