package ru.job4j.loop;

/**
 * Class Counter - solution of task
 * 4.1. Подсчет суммы чётных чисел в диапазоне [#192]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    private int totalEvens;

    /**
     * Constructor - initialises field totalEvens
     *
     */

    public Counter() {
        this.totalEvens = 0;
    }

    /**
     * Method add
     * @param start - start of diapason
     * @param finish - last number of diapason
     * @return field of class totalEvens
     */
    public int add(int start, int finish) {
        if (start % 2 == 0) {
            for (int i = start; i <= finish; i += 2) {
                this.totalEvens += i; }
        } else {
            for (int i = start + 1; i <= finish; i += 2) {
                this.totalEvens += i; } }

        return this.totalEvens;
    }
}
