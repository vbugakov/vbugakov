package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Class PaintTest - for testing methods of class Paint
 * task: 4. Используя шаблон проектирования - стратегию [#786]
 * and: 5. Рефакторинг теста @Before @After [#33568]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class PaintTest {
    /**
     * Class fields:
     * stdout - standard output (to console)
     * out - output to memory
     */

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();



    /**
     * Before tests
     */
    @Before
    public void outputToMemory() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * After Tests
     */
    @After
    public void outputToConsole() {
        System.setOut(stdout);
    }

    /**
     * Draw a square
     */
    @Test
    public void whenDrawSquare() {

        new Paint().draw(new Square());
            assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append(System.lineSeparator())
                                .append("++++")
                                .append(System.lineSeparator())
                                .append("++++")
                                .append(System.lineSeparator())
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * draw a triangle
     */

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(System.lineSeparator())
                                .append(" +++ ")
                                .append(System.lineSeparator())
                                .append("+++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}