package com.medicalclinic.serivce;

import com.medicalclinic.domain.entity.MedicalExamination;
import com.medicalclinic.repository.MedicalExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalExaminationService {
    @Autowired
    private MedicalExaminationRepository medicalExaminationRepository;

    public List<MedicalExamination> getAllMedicalExaminations() {
        return medicalExaminationRepository.findAll();
    }

    public Optional<MedicalExamination> getMedicalExamination(final long id) {
        return medicalExaminationRepository.findById(id);
    }

    public MedicalExamination saveMedicalExamination(MedicalExamination medicalExamination) {
        return medicalExaminationRepository.save(medicalExamination);
    }
}
