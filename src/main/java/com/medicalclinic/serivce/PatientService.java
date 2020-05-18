package com.medicalclinic.serivce;

import com.medicalclinic.domain.entity.Patient;
import com.medicalclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatient(final Long id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(final Patient patient) {
        return patientRepository.save(patient);
    }

}
