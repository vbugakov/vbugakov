package ru.job4j.array;

/**
 * Class Matrix -  solution of task:
 * 5.4. Двухмерный массив. Таблица умножения. [#33491]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class Matrix {

    /**
     * method multiple
     * @param size -  size of matrix.
     * @return 2d array filled by result of multiplying of indexes+1.
     */
    int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}
