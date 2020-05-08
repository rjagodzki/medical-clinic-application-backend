package com.medicalclinic.controller;

import com.medicalclinic.domain.dto.DoctorDto;
import com.medicalclinic.mapper.DoctorMapper;
import com.medicalclinic.serivce.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.medicalclinic.controller.NotFoundException.DOCTOR_NOT_FOUND_EXCEPTION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/doctors")
    public List<DoctorDto> getDoctors() {
        return doctorMapper.mapToDoctorDtoList(doctorService.getAllDoctors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctor/{doctorId}")
    public DoctorDto getDoctor(@PathVariable Long doctorId) throws NotFoundException {
        return doctorMapper.mapToDoctorDto(doctorService.getDoctor(doctorId)
                .orElseThrow(() -> new NotFoundException(DOCTOR_NOT_FOUND_EXCEPTION)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/doctor", consumes = APPLICATION_JSON_VALUE)
    public void createDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.saveDoctor(doctorMapper.mapToDoctor(doctorDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/doctor/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId) throws NotFoundException {
        doctorService.removeDoctor(doctorId);
    }
}
