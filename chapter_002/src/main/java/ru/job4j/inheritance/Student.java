package ru.job4j.inheritance;


/**
 * Class Student -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Student extends  Subject {

    private String lessonTheme;

    public Student(String name) {
        super(name);
        this.lessonTheme = "none";
    }

    public  Student(String name, String lessonTheme) {
        super(name);
        this.lessonTheme = lessonTheme;
    }

    public  String getLessonTheme() {
        return lessonTheme;
    }
}

