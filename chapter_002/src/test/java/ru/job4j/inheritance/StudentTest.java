package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class StudentTest - for testing methods of class Student
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */


public class StudentTest {
    @Test
    public void studentToStringPlusInheritance() {
        Student student = new Student("Doe John");
        String result = student.toString();
        String expected  = "Student - Mr Doe John";
        assertThat(result, is(expected));
        assertTrue(student instanceof  Subject);
    }

    @Test
    public  void thenStudentNonPresentOnLessonThenLessonThemeNone() {
        String result = new Student("Doe John").getLessonTheme();
        String expected  = "none";
        assertThat(result, is(expected));
    }

    @Test
    public  void thenStudentOnLessonThenLessonThemePresent() {
        String result = new Student("Doe John", "Alternation").getLessonTheme();
        String expected  = "Alternation";
        assertThat(result, is(expected));
    }

}
