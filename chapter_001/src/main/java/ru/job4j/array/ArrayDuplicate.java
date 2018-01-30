package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate -  solution of task:
 * 5.5. Удаление дубликатов в массиве. [#225]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * method multiple
     * @param array -  array for fixing.
     * @return  array with no duplicates corrected size.
     */

    public String[] remove(String[] array) {
        int unique = array.length;
        for (int i = 0; i < unique; i++) {
            String valueToCompare = array[i];
            for (int j = i + 1; j < unique; j++) {
                if (valueToCompare.equals(array[j])) {
                    array[j] = array[unique - 1];
                    unique--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }


}
