package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest - for testing class Max
 * solution of task 3.2. Максимум из двух чисел [#189]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {


    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        assertThat(
                maximum.max(1, 2),
                is(2));
    }
}
