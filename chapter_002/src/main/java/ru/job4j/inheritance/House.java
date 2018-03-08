package ru.job4j.inheritance;

/**
 * Class House -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class House extends Subject {

    String stage;

    /**
     * Constructor
     *
     * @param address sets a field of class - name when creates object
     * also sets field stage - stage of building by default
     */
    public House(String address) {
        super(address);
        this.stage = "project";
    }

    /**
     * Overloaded Constructor
     *
     * @param address sets a field of class - name when creates object
     * @param stage sets field stage
     */
    public House(String address, String stage) {
        super(address);
        this.stage = stage;
    }

    /**
     * Getter
     * @return stage
     */
    public String getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " On : " + super.getName();
    }
}
