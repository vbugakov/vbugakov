package ru.job4j.inheritance;

/**
 * Class Patient -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Patient extends  Subject {

    /**
     * Fields of class
     */
    private String disease;

    /**
     * constructor
     * @param name - patient name
     * also set field disease by default (healthy)
     */
    public Patient(String name) {
        super(name);
        this.disease = "none";
    }

    /**
     * Overloaded Constructor
     * @param name - name of patient
     * @param disease - name of disease
     */
    public  Patient(String name, String disease) {
        super(name);
        this.disease = disease;
    }

    /**
     * Getter
     * @return return disease
     */
    public  String getDisease() {
        return disease;
    }
}
