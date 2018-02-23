package ru.job4j;

/**
 * Class MergeArrays -  solution of task:
 * Доп задание. Соединить два отсортированных массива.[#42419]
 * Task description:
 * Обьединить два отсортированниых архива в один отсортированный
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class MergeArrays {
    /**
     * Merges two presorted arrays.
     * @param leftArray - array for merge
     * @param rightArray array for merge
     * @return one merged sorted array.
     */
    public int[] merge(int[] leftArray, int[] rightArray) {
        int[] resultArray = new int[leftArray.length + rightArray.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (l < leftArray.length && r < rightArray.length) {
                if (leftArray[l] < rightArray[r]) {
                    resultArray[i] = leftArray[l];
                    l++;
                } else {
                    resultArray[i] = rightArray[r];
                    r++;
                }
            } else if (l < leftArray.length) {
                resultArray[i] = leftArray[l];
                l++;
            } else if (r < rightArray.length) {
                resultArray[i] = rightArray[r];
                r++;
            }
        }

        return resultArray;
    }
}
