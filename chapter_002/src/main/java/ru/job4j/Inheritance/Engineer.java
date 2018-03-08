package ru.job4j.Inheritance;


/**
 * Class Engineer -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Engineer extends  Profession {

    public Engineer(String name) {
        super(name);
    }

   public Report build(House house){
        return new Report(this, house);
    }
}
