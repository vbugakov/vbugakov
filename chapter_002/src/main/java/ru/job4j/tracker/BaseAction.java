package ru.job4j.tracker;

/**
 * Class BaseAction -  solution of task:
 * 1. Рефакторинг - Перенести общие методы в абстрактный класс [#790]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public abstract class BaseAction implements UserAction {
    private static final String MENUFORMAT = "%s. %s.%n";
    private String name;
    private int key;

    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int key() {
        return this.key;
    }

    @Override
    public String toString() {
        return String.format(MENUFORMAT, this.key(), this.name);
    }

}
