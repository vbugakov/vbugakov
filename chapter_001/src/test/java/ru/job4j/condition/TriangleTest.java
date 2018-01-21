package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class TriangleTest - for testing methods of class Triangle.
 * from task 3.3. Вычисление площади треугольника [#9461]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {
    private Point a = new Point(0, 0);
    private Point b = new Point(0, 2);
    private Point c = new Point(2, 0);
    private Triangle triangle = new Triangle(a, b, c);

    /**
     * Тестируем метод area (треугольник который возможно построить)
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Тестируем реакцию метода area
     * (треугольник который НЕвозможно построить)
     */
    @Test
    public void whenNonTriangleThenMinusOne() {
        Triangle notriangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(0, 2));
        double result = notriangle.area();
        double expected = -1D;
        assertThat(result, is(expected));
    }

    /**
     * Тестируем метод period  на соответсвие формуле
     */
    @Test
    public void whenCalculationInPeriodThenSimilarToFormula() {
        double result = triangle.period(a.distanceTo(b), a.distanceTo(c), b.distanceTo(c));
        double expected = (a.distanceTo(b) + a.distanceTo(c) + b.distanceTo(c)) / 2;
        assertThat(result, is(expected));
    }


}
