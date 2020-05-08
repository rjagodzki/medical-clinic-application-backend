package com.medicalclinic;

import com.medicalclinic.domain.entity.Doctor;
import com.medicalclinic.domain.entity.Patient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FixedVariables {
    private final List<Patient> patientList = new ArrayList<>();
    private final List<Doctor> doctorList = new ArrayList<>();

    public static Patient RACHEL_GREEN = new Patient("Rachel", "Green", LocalDateTime.of(1969, 5, 5,0,0), "Long Island", true);
    public static Patient MONICA_GELLER = new Patient("Monica", "Geller",LocalDateTime.of(1969, 4, 22,0,0), "Long Island", true);
    public static Patient PHOEBE_BUFFAY = new Patient("Pheobe", "Buffay", LocalDateTime.of(66, 2, 16,0,0), "New York", true);
    public static Patient CHANDLER_BING = new Patient("Chandler", "Bing", LocalDateTime.of(67,4, 23,0,0), "Las Vegas", true);
    public static Patient JOEY_TRIBBIANI = new Patient("Joey", "Tribbiani", LocalDateTime.of(68, 2, 3,0,0), "Queens", true);
    public static Patient ROSS_GELLER = new Patient("Ross", "Geller", LocalDateTime.of(67, 5, 12,0,0), "Long Island", true);

    public static Doctor TED_MOSBY = new Doctor("Ted", "Mosby", "Dermatologist");
    public static Doctor MARSHALL_ERIKSEN = new Doctor("Marshall", "Eriksen", "Internist");
    public static Doctor LILY_ALDRIN = new Doctor("Lily", "Aldrin", "Pediatrician");
    public static Doctor ROBIN_SCHERBASTSKY = new Doctor("Robin", "Scherbatsky", "Psychologist");
    public static Doctor BARNEY_STINSON = new Doctor("Barney", "Stinson", "Gynecologist");

    public List<Patient> getPatientList() {
        patientList.add(RACHEL_GREEN);
        patientList.add(MONICA_GELLER);
        patientList.add(PHOEBE_BUFFAY);
        patientList.add(CHANDLER_BING);
        patientList.add(JOEY_TRIBBIANI);
        patientList.add(ROSS_GELLER);
        return patientList;
    }

    public List<Doctor> getDoctorList() {
        doctorList.add(TED_MOSBY);
        doctorList.add(MARSHALL_ERIKSEN);
        doctorList.add(LILY_ALDRIN);
        doctorList.add(ROBIN_SCHERBASTSKY);
        doctorList.add(BARNEY_STINSON);
        return doctorList;
    }
}
