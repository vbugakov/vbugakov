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
     * 0 0 0
     * 0 1 2
     * 0 2 4
     */
    @Test
    public void whenMatrixSizeTwoThenMultiplyTable() {
        int[][] result = new Matrix().multiple(3);
        int[][] expected = {{0, 0, 0}, {0, 1, 2}, {0, 2, 4}};
        assertThat(result, is(expected));
    }
}
