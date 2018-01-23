package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class FactorialTest - for testing methods of class Factorial
 * task 4.2. Создать программу вычисляющую факториал. [#193]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {




    /**
     * Test of method calc .
     * Should return factorial of n.
     * 5! = 120
     */
     @Test
     public void whenFiveThenOneHundredTwenty() {
          Factorial f = new Factorial();
          int result = f.calc(5);
          assertThat(result, is(120));
     }

    /**
     * Test of method calc .
     * Should return factorial of n.
     * 5! = 120
     */
    @Test
    public void whenZeroThenOne() {
        Factorial f = new Factorial();
        int result = f.calc(0);
        assertThat(result, is(1));
    }

}
