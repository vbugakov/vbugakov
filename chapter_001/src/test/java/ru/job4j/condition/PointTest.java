package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PointTest - for testing class Point
 * task 2.4. Расстояние между точками в системе координат. [#188]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class PointTest {
    /**
     * Constants block of manual testing class contains coordinates of points:
     * x of point 1 {@value #X1}
     * x of point 2 {@value #X2}
     * y of point 1 {@value #Y1}
     * y of point 2 {@value #Y2}
     */
    private static final int X1 = 1; //constant x of point 1
    private static final int Y1 = 2; //constant y of point 1
    private static final int X2 = 3; //constant x of point 2
    private static final int Y2 = 4; //constant y of point 2

    /**
     * Test for method distanceTo.
     * @author (Copy paste)
     */
    @Test
    public void whenCalculateInMethodThenEqualToFormula() {
        Point a = new Point(X1, Y1);
        Point b = new Point(X2, Y2);
        double result = a.distanceTo(b);
        double expected = Math.sqrt(Math.pow(X1 - X2, 2) + Math.pow(Y1 - Y2, 2));
        assertThat(result, is(expected));
    }
}
