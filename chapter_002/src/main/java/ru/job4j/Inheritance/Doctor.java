package ru.job4j.Inheritance;

/**
 * Class Doctor -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Doctor extends Profession {

    public  Doctor(String name){
        super(name);
    }

    public Diagnose examine (Patient patient) {
        return new Diagnose(this, patient);
    }

}
