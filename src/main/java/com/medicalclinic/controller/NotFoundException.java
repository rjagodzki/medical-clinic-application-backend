package com.medicalclinic.controller;
// TODO: Zrób dobrą klasę Exception do wszystkich kontrollerów
public class NotFoundException extends Exception{
    public static String APPOINTMENT_NOT_FOUND_EXCEPTION = "Appointment does not exist!";
    public static String DOCTOR_NOT_FOUND_EXCEPTION = "Doctor does not exist!";
    public static String MEDICAL_EXAMINATION_NOT_FOUND_EXCEPTION = "Medical examination does not exist!";
    public static String PATIENT_NOT_FOUND_EXCEPTION = "Patient does not exist!";
    public static String PRESCRIPTION_NOT_FOUND_EXCEPTION = "Prescription does not exist!";

    public NotFoundException(String message) {
        super(message);
    }
}

//FIXME: not found exception