package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class EngineerTest - for testing methods of class Engineer
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class EngineerTest {

    @Test
    public void engineerToStringPlusInheritance() {
        Engineer engineer = new Engineer("Doe John");
        String result = engineer.toString();
        String expected  = "Engineer - Mr Doe John";
        assertThat(result, is(expected));
        assertTrue(engineer instanceof  Profession);
    }

    @Test
    public  void whenEngineerNotStartYetThenNotStarted() {
        String result = new Engineer("John Doe").build(new House("Baker Street 216, London")).toString();
        String expected = "Building report:\r\nHouse On : Baker Street 216, London in condition: building not started\r\n"
                + "Responsible:\r\nEngineer - Mr John Doe";
        assertThat(result, is(expected));

    }

    @Test
    public  void whenEngineerStartToBuildThenShowingStage() {
        String result = new Engineer("John Doe").build(new House("Baker Street 216, London", "Basement")).toString();
        String expected = "Building report:\r\nHouse On : Baker Street 216, London in condition: Building Basement\r\n"
                + "Responsible:\r\nEngineer - Mr John Doe";
        assertThat(result, is(expected));

    }


}
