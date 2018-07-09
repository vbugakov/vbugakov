package ru.job4j.search;

/**
 * Class Task -  solution of task:
 * 2. Очередь с приоритетом на LinkedList [#41670]
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version %Id%
 * @since 0.1
 */

public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

}
