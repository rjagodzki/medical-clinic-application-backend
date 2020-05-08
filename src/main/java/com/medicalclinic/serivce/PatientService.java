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
    // FIXME: setStatus() ???
    // TODO: A może by tak sortować listę po statusie? Na dole pacjenci z active = false, albo dodać jakieś filtry we front-endzie
//
//    public Patient setStatus(final Long id, final Boolean status) {
//        return patientRepository.findById(id).s
//    }
}
