package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class PatientTest - for testing methods of class Patient
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class PatientTest {

    @Test
    public void patientToStringPlusInheritance() {
        Patient patient = new Patient("Doe John");
        String result = patient.toString();
        String expected  = "Patient - Mr Doe John";
        assertThat(result, is(expected));
        assertTrue(patient instanceof  Subject);
    }

    @Test
    public  void thenPatientHealthyThenDiseaseNone() {
        Patient patient = new Patient("Doe John");
        String result = patient.getDisease();
        String expected  = "none";
        assertThat(result, is(expected));
    }

    @Test
    public  void thenPatientSeekThenDisease() {
        Patient patient = new Patient("Doe John", "allergy");
        String result = patient.getDisease();
        String expected  = "allergy";
        assertThat(result, is(expected));
    }
}