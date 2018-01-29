package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSortTest - for testing methods of class BubbleSort
 * task 5.3. Создать программу для сортировки массива методом перестановки. [#195]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {

    /**
     * Test for method sort.
     * return sorted array
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька,
        // например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        int[] result = new BubbleSort().sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }
}
