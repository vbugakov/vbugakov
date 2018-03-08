package ru.job4j.inheritance;

/**
 * Class Profession -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public abstract class Profession {
    /**
     * Fields of class
     */
    private String name;

    /**
     * Constructor
     * @param name
     * sets a field of class - name when creates object
     */
    public Profession(String name) {
        this.name = name;
    }


    /**
     * Overrided to string
     * @return returns string by condition
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Mr " + name;
    }

}
