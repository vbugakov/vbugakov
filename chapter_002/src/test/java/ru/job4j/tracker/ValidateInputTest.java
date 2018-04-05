package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class  ValidateInputTest - for testing methods of class  ValidateInput
 * task: 2. Рефакторинг - Шаблон Декоратор для валидатора. [#34117]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ValidateInputTest {
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
     * Case of Not a Number input.
     */
    @Test
    public void whenNaNInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"a", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Введите число. Ввод должен быть от 0 до 6.%n")
                )
        );
    }

    /**
     * Case of Out of menu range input.
     */
    @Test
    public void whenOutOfMenuRangeInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-1", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Ввод должен быть от 0 до 6.%n")
                )
        );
    }
}