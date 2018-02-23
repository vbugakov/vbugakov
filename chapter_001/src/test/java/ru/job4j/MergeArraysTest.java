package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MergeArraysTest - for testing methods of class MergeArays
 * task: Доп задание. Соединить два отсортированных массива.[#42419]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class MergeArraysTest {
    /**
     * test of merge method
     * receive two array [1, 2] & [3, 4]
     * returns [1, 2, 3, 4]
     */
    @Test
    public void whenTwoPresortedThenOneMergedSorted() {
        int[] result = new MergeArrays().merge(new int[] {1, 2}, new int[] {3, 4});
        int[] expected = {1, 2, 3, 4};
        assertThat(result, is(expected));
    }
}