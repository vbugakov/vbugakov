package ru.job4j.array;

/**
 * Class BubbleSort -  solution of task:
 * 5.3. Создать программу для сортировки массива методом перестановки. [#195]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class BubbleSort {
    /**
     * method sort
     * @param array -  array for sort
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        int buffer;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
     return array;
    }
}
