package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CalculatorTest - for testing class Calculator
 * from task 2.3. Элементарный калькулятор. [#185]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {

    /**
     * Test for method add.
     * @author (Copy paste)
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method sub.
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    @Test
    public void whenTwoSubtractFromFiveThenThree() {
        Calculator calc = new Calculator();
        calc.sub(5D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method mult.
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    @Test
    public void whenTwoMultipliedByFiveThenTen() {
        Calculator calc = new Calculator();
        calc.mult(5D, 2D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }

    /**
     * Test for method div.
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    @Test
    public void whenTenDividedByFiveThenTwo() {
        Calculator calc = new Calculator();
        calc.div(10D, 5D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
