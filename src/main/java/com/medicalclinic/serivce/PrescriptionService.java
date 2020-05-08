package com.medicalclinic.serivce;

import com.medicalclinic.domain.entity.Prescription;
import com.medicalclinic.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> getPrescription(final Long id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
}
