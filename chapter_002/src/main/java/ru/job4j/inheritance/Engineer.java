package ru.job4j.inheritance;


/**
 * Class Engineer -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Engineer extends  Profession {

    /**
     * Constructor
     * @param name - name of engineer
     */
    public Engineer(String name) {
        super(name);
    }

    /**
     * methode build
     * @param house - object of class House
     * @return - object of class Report (Building report)
     */
   public Report build(House house) {
        return new Report(this, house);
    }
}
