package ru.job4j.inheritance;
/**
 * Class Lesson -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Lesson {
    /**
     * Fields of class
     */
    private Teacher teacher;
    private Student student;

    /**
     * Constructor
     * @param teacher
     * @param student
     */
    public Lesson(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    /**
     * method buildClassRoom Report - builds string variable by condition
     * @return string variable by condition
     */
    private String buildClassRoomReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classroom report:");
        sb.append(System.lineSeparator());
        sb.append(student);
        if ((student.getLessonTheme().equals("none"))) {
            sb.append(" haven't been on lesson");
        } else {
            sb.append(" have been on lesson : \'" + student.getLessonTheme() + "\'");
        }
        sb.append(System.lineSeparator());
        sb.append("Checked by:");
        sb.append(System.lineSeparator());
        sb.append(teacher);
        return sb.toString();
    }

    @Override
    public String toString() {
        return buildClassRoomReport();
    }
}


