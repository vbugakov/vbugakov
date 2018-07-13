package ru.job4j.list;

import java.util.List;
import java.util.ArrayList;

/**
 * Class ConvertMatrix2List -  solution of task:
 * 3. Конвертация двумерного массива в ArrayList [#48580]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ConvertMatrix2List {
    /**
     * public List<Integer> toList (int[][] array) {} - в метод приходит двумерный массив целых чисел,
     * необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
     * Внутри методов использовать foreach.
     * @param array
     * @return List<Integer>
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell: row) {
                list.add(cell);
            }
        }
        return list;
    }
}
