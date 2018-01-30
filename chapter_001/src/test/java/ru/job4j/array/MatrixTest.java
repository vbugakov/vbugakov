package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MatrixTest - for testing methods of class Matrix
 * 5.4. Двухмерный массив. Таблица умножения. [#33491]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class MatrixTest {
    /**
     * Test for method multiple.
     * when size of matrix - 3
     * should return;
     * 1 2 3
     * 2 4 6
     * 3 6 9
     */
    @Test
    public void whenMatrixSizeTwoThenMultiplyTable() {
        int[][] result = new Matrix().multiple(3);
        int[][] expected = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(expected));
    }
}
