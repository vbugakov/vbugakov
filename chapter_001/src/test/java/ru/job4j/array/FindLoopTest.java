package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FindLoopTest - for testing methods of class FindLoop
 * task 5.1. Классический поиск перебором. [#33489]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {

    public static  final int[] TESTARRAY = {1, 3, 6, 2, 7};
    /**
     * Test for method indexOf.
     * look for 3 in TESTARRAY returns 1
     */
    @Test
    public void whenThreeThenOne() {
        FindLoop arr = new FindLoop();
        int result = arr.indexOf(TESTARRAY, 3);
        assertThat(result, is(1));
    }

    @Test
    public void whenEightThenMinusOne() {
        FindLoop arr = new FindLoop();
        int result = arr.indexOf(TESTARRAY, 8);
        assertThat(result, is(-1));
    }

}
