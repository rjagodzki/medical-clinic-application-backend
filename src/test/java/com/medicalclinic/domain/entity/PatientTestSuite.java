package com.medicalclinic.domain.entity;

import com.medicalclinic.FixedVariables;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTestSuite {
    @Test
    public void createPatientTest() {
        // Given
        Patient patient = FixedVariables.RACHEL_GREEN;

        // When
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        LocalDate dateOfBirth = patient.getDateOfBirth();
        String placeOfBirth = patient.getPlaceOfBirth();
        String phoneNumber = patient.getPhoneNumber();
        String emailAddress = patient.getEmailAddress();
        String authorizedPerson = patient.getAuthorizedPerson();
        Boolean active = patient.getActive();

        // Then
        assertEquals("Rachel", firstName);
        assertEquals("Green", lastName);
        assertEquals(LocalDate.of(1969, 5, 5), dateOfBirth);
        assertEquals("Long Island", placeOfBirth);
        assertEquals("444777111", phoneNumber);
        assertEquals("rachel.green@friends.com", emailAddress);
        assertEquals("Gunther", authorizedPerson);
        assertTrue(active);
    }

}