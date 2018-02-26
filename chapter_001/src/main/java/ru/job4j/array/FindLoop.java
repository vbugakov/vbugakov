package ru.job4j.array;

/**
 * Class FindLoop -  solution of task:
 * 5.1. Классический поиск перебором. [#33489]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class FindLoop {

    /**
     * method indexOf
     * from 1 to bound
     * @param data -  array for search
     * @param element - value  for search
     * @return index of first founded element in array by value if not founded -1.
     */

    public int indexOf(int[] data, int element) {

        int result = -1; // если элемента нет в массиве, то возвращаем -1.

        for (int index = 0; index < data.length; index++) {
            if (data[index] == element) {
                result = index;
                break;
            }
        }
       return result;
    }
}
