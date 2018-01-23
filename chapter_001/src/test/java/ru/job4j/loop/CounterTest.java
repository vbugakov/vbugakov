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
     */
    @Test
    public void whenDiapasonOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }



}
