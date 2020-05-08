package com.medicalclinic.controller;

import com.medicalclinic.domain.dto.AppointmentDto;
import com.medicalclinic.mapper.AppointmentMapper;
import com.medicalclinic.serivce.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.medicalclinic.controller.NotFoundException.APPOINTMENT_NOT_FOUND_EXCEPTION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/appointments")
    public List<AppointmentDto> getAppointments() {
        return appointmentMapper.mapToAppointmentDtoList(appointmentService.getAllAppointments());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/appointment")
    public AppointmentDto getAppointment(@RequestParam Long appointmentId) throws NotFoundException {
        return appointmentMapper.mapToAppointmentDto(appointmentService.getAppointment(appointmentId)
                .orElseThrow(() -> new NotFoundException(APPOINTMENT_NOT_FOUND_EXCEPTION)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/appointment", consumes = APPLICATION_JSON_VALUE)
    public void createAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.saveAppointment(appointmentMapper.mapToAppointment(appointmentDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/appointment")
    public void cancelAppointment(@RequestParam Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }
}

