package ru.job4j.max;
/**
 * Class Max - solution of task 3.2. Максимум из двух чисел [#189]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * method max - compares two ints not include
     * and returns maximum
     * @param first - first number
     * @param second - second number
     * @return  maximum from two numbers
     */
    public int max(int first, int second) {
        return first < second ? second : first;
    }
}
