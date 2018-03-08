package ru.job4j.Inheritance;



/**
 * Class Teacher -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Teacher extends  Profession {

    public Teacher(String name) {
        super(name);
    }

    public Lesson teach(Student student){
        return new Lesson(this, student);
    }
}
