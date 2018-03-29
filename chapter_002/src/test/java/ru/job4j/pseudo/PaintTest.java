package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Class PaintTest - for testing methods of class Paint
 * task: 4. Используя шаблон проектирования - стратегию [#786]
 * and 5. Рефакторинг теста @Before @After [#33568]
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

    private void outputToMemory() {
        System.setOut(new PrintStream(this.out));
    }
    private void outputToConsole() {
        System.setOut(stdout);
    }
    /**
     * Draw a square
     */
    @Test
    public void whenDrawSquare() {

        outputToMemory();
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
        outputToConsole();
    }

    /**
     * draw a triangle
     */

    @Test
    public void whenDrawTriangle() {
        outputToMemory();
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
        outputToConsole();
    }
}