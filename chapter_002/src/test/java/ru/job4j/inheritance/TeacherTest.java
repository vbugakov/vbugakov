package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class TeacherTest - for testing methods of class Teacher
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */


public class TeacherTest {

    @Test
    public void teacherToStringPlusInheritance() {
        Teacher teacher = new Teacher("John Doe");
        String result = teacher.toString();
        String expected = "Teacher - Mr John Doe";
        assertThat(result, is(expected));
        assertTrue(teacher instanceof Profession);
    }

    @Test
    public  void whenTeacherSeeNonPresentStudent() {
        String result = new Teacher("John Doe").teach(new Student("Rinaldo Rinaldini")).toString();
        String expected = "Classroom report:\r\nStudent - Mr Rinaldo Rinaldini haven't been on lesson\r\nChecked by:\r\nTeacher - Mr John Doe";
        assertThat(result, is(expected));

    }

    @Test
    public  void whenStudentOnLesson() {
        String result = new Teacher("John Doe").teach(new Student("Rinaldo Rinaldini", "Alternation")).toString();
        String expected = "Classroom report:\r\nStudent - Mr Rinaldo Rinaldini have been on lesson : 'Alternation'\r\nChecked by:\r\nTeacher - Mr John Doe";
        assertThat(result, is(expected));

    }

}
