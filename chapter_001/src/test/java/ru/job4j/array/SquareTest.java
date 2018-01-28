package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class -  solution of task:
 *
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class SquareTest {

    /**
     * Test for method calculate.
     * for .calculate(4) should return {1, 4, 9, 16}
     */
    @Test
    public void whenFourThenPoweredFromOneToFour() {
        Square square = new Square();
        int[] result = square.calculate(4);
        int[] expected = new int[]{1, 4, 9, 16};

        assertThat(result, is(expected));
    }
}
