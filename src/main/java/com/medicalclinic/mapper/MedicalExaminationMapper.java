package com.medicalclinic.mapper;

import com.medicalclinic.domain.dto.MedicalExaminationDto;
import com.medicalclinic.domain.entity.MedicalExamination;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalExaminationMapper {
    public MedicalExamination mapToMedicalExamination (final MedicalExaminationDto medicalExaminationDto) {
        return new MedicalExamination(
                medicalExaminationDto.getMedicalExaminationId(),
                medicalExaminationDto.getCreatedDate(),
                medicalExaminationDto.getExaminationDate()
        );
    }

    public MedicalExaminationDto mapToMedicalExaminationDto (final MedicalExamination medicalExamination) {
        return new MedicalExaminationDto(
                medicalExamination.getMedicalExaminationId(),
                medicalExamination.getCreatedDate(),
                medicalExamination.getExaminationDate()
        );
    }

    public List<MedicalExaminationDto> mapToMedicalExaminationDtoList(final List<MedicalExamination> medicalExaminationList) {
        return medicalExaminationList.stream()
                .map(medicalExamination -> new MedicalExaminationDto(
                        medicalExamination.getMedicalExaminationId(),
                        medicalExamination.getCreatedDate(),
                        medicalExamination.getExaminationDate()))
                .collect(Collectors.toList());
    }
}
