package com.medicalclinic.repository;

import com.medicalclinic.domain.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Override
    List<Doctor> findAll();
}
