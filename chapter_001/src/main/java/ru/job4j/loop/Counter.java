package ru.job4j.loop;

/**
 * Class Counter - solution of task
 * 4.1. Подсчет суммы чётных чисел в диапазоне [#192]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    /**
     * Method add
     * @param start - start of diapason
     * @param finish - last number of diapason
     * @return total total of all even numbers in diapason
     */
    public int add(int start, int finish){
        int total=0;
        for (int i =start;i<=finish;i++)
            if(i % 2 == 0) total += i;

        return total;
    }
}
