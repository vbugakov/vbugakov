package ru.job4j.Inheritance;
/**
 * Class Lesson -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Lesson {
    private Teacher teacher;
    private Student student;

    public Lesson(Teacher teacher,Student student){
        this.teacher = teacher;
        this.student = student;
    }

    private String buildClassRoomReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classroom report:");
        sb.append(System.lineSeparator());
        sb.append(student);
        if ((student.getLessonTheme().equals("none"))) {
            sb.append(" haven't been on lesson");
        } else {
            sb.append(" have been on lesson : \'" + student.getLessonTheme()+ "\'");
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


