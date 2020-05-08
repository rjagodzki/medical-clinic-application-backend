package com.medicalclinic.mapper;

import com.medicalclinic.domain.dto.DoctorDto;
import com.medicalclinic.domain.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {
    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getDoctorId(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getSpecialization(),
                doctorDto.getPhoneNumber(),
                doctorDto.getEmailAddress()
        );
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return new DoctorDto(
                doctor.getDoctorId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialization(),
                doctor.getPhoneNumber(),
                doctor.getEmailAddress()
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(
                        doctor.getDoctorId(),
                        doctor.getFirstName(),
                        doctor.getLastName(),
                        doctor.getSpecialization(),
                        doctor.getPhoneNumber(),
                        doctor.getEmailAddress()))
                .collect(Collectors.toList());
    }
}
