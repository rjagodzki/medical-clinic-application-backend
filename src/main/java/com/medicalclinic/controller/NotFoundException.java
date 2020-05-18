package com.medicalclinic.controller;

public class NotFoundException extends Exception {
    public static String APPOINTMENT_NOT_FOUND_EXCEPTION = "Appointment does not exist!";
    public static String DOCTOR_NOT_FOUND_EXCEPTION = "Doctor does not exist!";
    public static String PATIENT_NOT_FOUND_EXCEPTION = "Patient does not exist!";

    public NotFoundException(String message) {
        super(message);
    }
}
