package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CheckContainsTest - for testing methods of class CheckContains
 * Проверка, что одно слово находится в другом слове [#228]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class CheckContainsTest {
    private CheckContains check = new CheckContains();
    /**
     * Test for method contains.
     * for origin = "Привет" and sub = "иве"
     * should return true;
     */
    @Test
    public void whenContainsThenTrue() {
        assertThat(check.contains("Привет", "иве"), is(true));
    }

    /**
     * Test for method contains.
     * for origin = "Привет" and sub = "веи"
     * should return false;
     */
    @Test
    public void whenNoContainsThenFalse() {
        assertThat(check.contains("Привит", "иве"), is(false));
    }

    /**
     * Test for method contains.
     * for origin = "Привет" and sub = "иве"
     * should return true;
     */
    @Test
    public void whenContainsVersionTwoThenTrue() {
        assertThat(check.containsCheat("Привет", "иве"), is(true));
    }
}

