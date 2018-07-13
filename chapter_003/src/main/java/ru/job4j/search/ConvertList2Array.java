package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList2Array -  solution of task:
 * 3. Конвертация ArrayList в двухмерный массив [#10035],
 * 1. Конвертация листа массивов в один лист Integer [#10037]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ConvertList2Array {
    /**
     * public int[][] toArray (List<Integer> list, int rows) {}
     * должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству
     * строк - оставшиеся значения
     * в массиве заполнять нулями.
     * Внутри методов использовать foreach.
     * @param list - list for converting
     * @param rows - size of matrix
     */
    public int[][]toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] result = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer value : listValidate(list, rows)) {
            result[(j % cells == 0 && j != 0) ? ++i : i][j % cells] = value;
            j++;
        }
        return result;
    }
/**
 * В методе toArray должна быть проверка - если количество элементов не кратно количеству
 * строк - оставшиеся значения
 * PS не уверен, что она нужна - массив и так "добивается" нулями.
 */
    private List<Integer> listValidate(List<Integer> list, int rows) {
        List<Integer> result = new ArrayList<Integer>(list);
        for (int i = 0; i < result.size() % rows; i++) {
            result.add(0);
        }
        return result;
    }
    /**
     * В классе ConvertList из 3-го задания 1-го урока написать метод:
     * public List<Integer> convert (List<int[]> list)
     * В этом методе вы должны пройтись по всем элементам всех массивов в списке list и
     * добавить их в один общий лист Integer.
     * Массивы в списке list могут быть разного размера.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }

}
