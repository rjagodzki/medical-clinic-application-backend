package com.medicalclinic.repository;

import com.medicalclinic.domain.entity.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {
}
