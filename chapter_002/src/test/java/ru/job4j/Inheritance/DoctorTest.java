package ru.job4j.Inheritance;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class ProfessionTest - for testing methods of class Profession
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class DoctorTest {

    @Test
    public void DoctorToStringPlusInheritance() {
        Doctor doc = new Doctor("John Doe");
        String result = doc.toString();
        String expected = "Doctor - Mr John Doe";
        assertThat(result, is(expected));
        assertTrue(doc instanceof Profession);
    }

    @Test
    public  void whenDoctorExamineHealthyPatient() {
      String result = new Doctor("John Doe").examine(new Patient("Rinaldo Rinaldini")).toString();
      String expected = "Diagnosis:\r\nPatient - Mr Rinaldo Rinaldini is healthy\r\nExamined by:\r\nDoctor - Mr John Doe";
      assertThat(result, is(expected));

    }

    @Test
    public  void whenDoctorExamineDiseasedPatient() {
        String result = new Doctor("John Doe").examine(new Patient("Rinaldo Rinaldini","Allergy")).toString();
        String expected = "Diagnosis:\r\nPatient - Mr Rinaldo Rinaldini is diseased by : Allergy\r\nExamined by:\r\nDoctor - Mr John Doe";
        assertThat(result, is(expected));

    }

}

