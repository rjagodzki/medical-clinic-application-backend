package com.medicalclinic.mapper;

import com.medicalclinic.domain.dto.AppointmentDto;
import com.medicalclinic.domain.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper {
    public Appointment mapToAppointment(final AppointmentDto appointmentDto) {
        return new Appointment(
                appointmentDto.getAppointmentId(),
                appointmentDto.getAppointmentType(),
                appointmentDto.getAppointmentDate(),
                appointmentDto.getAppointmentTime(),
                appointmentDto.getCreatedDate(),
                appointmentDto.getCreatedTime(),
                appointmentDto.getPatient(),
                appointmentDto.getDoctor()
        );
    }

    public AppointmentDto mapToAppointmentDto(final Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getAppointmentType(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getCreatedDate(),
                appointment.getCreatedTime(),
                appointment.getPatient(),
                appointment.getDoctor()
        );
    }

    public List<AppointmentDto> mapToAppointmentDtoList(final List<Appointment> appointmentList) {
        return appointmentList.stream()
                .map(appointment -> new AppointmentDto(
                        appointment.getAppointmentId(),
                        appointment.getAppointmentType(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentTime(),
                        appointment.getCreatedDate(),
                        appointment.getCreatedTime(),
                        appointment.getPatient(),
                        appointment.getDoctor()))
                .collect(Collectors.toList());
    }
}
