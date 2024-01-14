package com.hospital_doctor_patient;

 
import java.util.Comparator;

public class Comparator_PatientId implements Comparator<Integer> {
    @Override
    public int compare(Integer id1, Integer id2) {
        return id2.compareTo(id1);
    }
}
