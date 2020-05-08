package com.medicalclinic.repository;

import com.medicalclinic.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Override
    List<Patient> findAll();
}
