package ru.job4j.inheritance;

/**
 * Class Subject -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public abstract class Subject {
    /**
     * Fields of class
     */
    private String name;

    /**
     * Constructor
     * @param name
     * sets a field of class - name when creates object
     */
    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Mr " + name;
    }

}
