package com.medicalclinic.mapper;

import com.medicalclinic.domain.dto.PatientDto;
import com.medicalclinic.domain.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(
                patientDto.getPatientId(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getDateOfBirth(),
                patientDto.getPlaceOfBirth(),
                patientDto.getPhoneNumber(),
                patientDto.getEmailAddress(),
                patientDto.getAuthorizedPerson(),
                patientDto.getActive()
        );
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDateOfBirth(),
                patient.getPlaceOfBirth(),
                patient.getPhoneNumber(),
                patient.getEmailAddress(),
                patient.getAuthorizedPerson(),
                patient.getActive()
        );
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(patient -> new PatientDto(
                        patient.getPatientId(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getDateOfBirth(),
                        patient.getPlaceOfBirth(),
                        patient.getPhoneNumber(),
                        patient.getEmailAddress(),
                        patient.getAuthorizedPerson(),
                        patient.getActive()))
                .collect(Collectors.toList());
    }
}
