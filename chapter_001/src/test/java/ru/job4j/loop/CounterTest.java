package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest - for testing metods of class Counter
 * task 4.1. Подсчет суммы чётных чисел в диапазоне [#192]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    /**
     * Test of method add .
     * Should return total of all even number in diapason.
     * Start from 1 to 10
     */
    @Test
    public void whenDiapasonOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }

    /**
     * Test of method add .
     * Should return total of all even number in diapason.
     * Start from 2 to 11
     */
    @Test
    public void whenDiapasonTwoToElevenThenThirty() {
        Counter count = new Counter();
        int result = count.add(2, 11);
        assertThat(result, is(30));
    }

    /**
     * Test of method add .
     * Should return total of all even number in diapason.
     * Start from 1 to 9
     */
    @Test
    public void whenDiapasonOneToNineThenTwenty() {
        Counter count = new Counter();
        int result = count.add(1, 9);
        assertThat(result, is(20));
    }



}
