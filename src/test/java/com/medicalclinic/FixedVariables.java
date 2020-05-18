package com.medicalclinic;

import com.medicalclinic.domain.dto.AppointmentType;
import com.medicalclinic.domain.entity.Appointment;
import com.medicalclinic.domain.entity.Doctor;
import com.medicalclinic.domain.entity.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FixedVariables {
    private final List<Patient> patientList = new ArrayList<>();
    private final List<Doctor> doctorList = new ArrayList<>();
    private final List<Appointment> appointmentList = new ArrayList<>();

    public static Patient RACHEL_GREEN = new Patient("Rachel", "Green", LocalDate.of(1969, 5, 5), "Long Island", "444777111", "rachel.green@friends.com", "Gunther", true);
    public static Patient MONICA_GELLER = new Patient("Monica", "Geller", LocalDate.of(1969, 4, 22), "Long Island", "123456789", "monica.geller@friends.com", "Richard Burke", true);
    public static Patient PHOEBE_BUFFAY = new Patient("Phoebe", "Buffay", LocalDate.of(1966, 2, 16), "New York", "222123444", "pheobe.buffay@friends.com", "Mike Hannigan", true);
    public static Patient CHANDLER_BING = new Patient("Chandler", "Bing", LocalDate.of(1967, 4, 23), "Las Vegas", "323231551", "chandler.bing@friends.com", "Janice Hosenstein", true);
    public static Patient JOEY_TRIBBIANI = new Patient("Joey", "Tribbiani", LocalDate.of(1968, 2, 3), "Queens", "232444555", "joey.tribbiani@friends.com", "Estelle Leonard", true);
    public static Patient ROSS_GELLER = new Patient("Ross", "Geller", LocalDate.of(1967, 5, 12), "Long Island", "345125678", "ross.geller@friends.com", "Susan Bunch", true);

    public static Doctor TED_MOSBY = new Doctor("Ted", "Mosby", "Dermatologist", "441234657", "ted.mosby@himym.com");
    public static Doctor MARSHALL_ERIKSEN = new Doctor("Marshall", "Eriksen", "Internist", "321456789", "marshall.eriksen@himym.com");
    public static Doctor LILY_ALDRIN = new Doctor("Lily", "Aldrin", "Pediatrician", "123123123", "lily.aldrin@himym.com");
    public static Doctor ROBIN_SCHERBASTSKY = new Doctor("Robin", "Scherbatsky", "Psychologist", "456123789", "robin.scherbatsky@himym.com");
    public static Doctor BARNEY_STINSON = new Doctor("Barney", "Stinson", "Gynecologist", "811945681", "barney.stinson@himym.com");

    public static Appointment SAMPLE_APPOINTMENT_ONE = new Appointment(1L, AppointmentType.BLOOD_TEST, LocalDate.of(2010, 10, 10), LocalTime.of(10, 10), LocalDate.now(), LocalTime.now(), PHOEBE_BUFFAY, BARNEY_STINSON);
    public static Appointment SAMPLE_APPOINTMENT_TWO = new Appointment(1L, AppointmentType.BLOOD_TEST, LocalDate.of(2010, 10, 10), LocalTime.of(10, 10), LocalDate.now(), LocalTime.now(), PHOEBE_BUFFAY, BARNEY_STINSON);
    public static Appointment SAMPLE_APPOINTMENT_THREE = new Appointment(1L, AppointmentType.BLOOD_TEST, LocalDate.of(2010, 10, 10), LocalTime.of(10, 10), LocalDate.now(), LocalTime.now(), PHOEBE_BUFFAY, BARNEY_STINSON);

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

    public List<Appointment> getAppointmentList() {
        appointmentList.add(SAMPLE_APPOINTMENT_ONE);
        appointmentList.add(SAMPLE_APPOINTMENT_TWO);
        appointmentList.add(SAMPLE_APPOINTMENT_THREE);
        return appointmentList;
    }
}
