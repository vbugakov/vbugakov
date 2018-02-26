package ru.job4j.array;

/**
 * Class  Square -  solution of task:
 * 5.0. Заполнить массив степенями чисел. [#33488]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class Square {
    /**
     * method calculate - fill up the array with powered numbers
     * from 1 to bound
     * @param bound - size of array
     * @return filled array by powered numbers from 1 to bound.
     */

    public int[] calculate(int bound) {

        int[] result = new int[bound];

        for (int i = 0; i < bound; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}
