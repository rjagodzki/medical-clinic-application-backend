package com.medicalclinic.mapper;

import com.medicalclinic.domain.dto.PrescriptionDto;
import com.medicalclinic.domain.entity.Appointment;
import com.medicalclinic.domain.entity.Prescription;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrescriptionMapper {
    public Prescription mapToPrescription(final PrescriptionDto prescriptionDto) {
        return new Prescription(
                prescriptionDto.getPrescriptionId(),
                prescriptionDto.getCreatedDate(),
                prescriptionDto.getExpiredDate(),
                prescriptionDto.getDrugOne(),
                prescriptionDto.getDosageOfDrugOne(),
                prescriptionDto.getDrugTwo(),
                prescriptionDto.getDosageOfDrugTwo(),
                prescriptionDto.getDrugThree(),
                prescriptionDto.getDosageOfDrugThree(),
                prescriptionDto.getDrugFour(),
                prescriptionDto.getDosageOfDrugFour(),
                prescriptionDto.getDrugFive(),
                prescriptionDto.getDosageOfDrugFive()
        );
    }

    public PrescriptionDto mapToPrescriptionDto(final Prescription prescription) {
        return new PrescriptionDto(
                prescription.getPrescriptionId(),
                prescription.getCreatedDate(),
                prescription.getExpiredDate(),
                prescription.getDrugOne(),
                prescription.getDosageOfDrugOne(),
                prescription.getDrugTwo(),
                prescription.getDosageOfDrugTwo(),
                prescription.getDrugThree(),
                prescription.getDosageOfDrugThree(),
                prescription.getDrugFour(),
                prescription.getDosageOfDrugFour(),
                prescription.getDrugFive(),
                prescription.getDosageOfDrugFive());
    }

    public List<PrescriptionDto> mapToPrescriptionDtoList(final List<Prescription> prescriptionList) {
        return prescriptionList.stream()
                .map(prescription -> new PrescriptionDto(
                        prescription.getPrescriptionId(),
                        prescription.getCreatedDate(),
                        prescription.getExpiredDate(),
                        prescription.getDrugOne(),
                        prescription.getDosageOfDrugOne(),
                        prescription.getDrugTwo(),
                        prescription.getDosageOfDrugTwo(),
                        prescription.getDrugThree(),
                        prescription.getDosageOfDrugThree(),
                        prescription.getDrugFour(),
                        prescription.getDosageOfDrugFour(),
                        prescription.getDrugFive(),
                        prescription.getDosageOfDrugFive()))
                .collect(Collectors.toList());
    }
}