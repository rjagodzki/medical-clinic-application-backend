package com.medicalclinic.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionTest {
    @Test
    public void test() {
        Prescription prescription = new Prescription();

        prescription.setCreatedDate();
        prescription.setExpiredDate();
        System.out.println(prescription.getExpiredDate().toString());
    }

}