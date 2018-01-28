package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Square Test -  for testing methods of class Square:
 * task: 5.0. Заполнить массив степенями чисел. [#33488]
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
