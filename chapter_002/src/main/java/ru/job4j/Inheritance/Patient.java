package ru.job4j.Inheritance;

/**
 * Class Patient -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Patient extends  Subject {

    private String disease;

    public Patient(String name) {
        super(name);
        this.disease = "none";
    }

    public  Patient (String name, String disease) {
        super(name);
        this.disease = disease;
    }

    public  String getDisease() {
        return disease;
    }
}
