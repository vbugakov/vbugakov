package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test for methods of class Calculate. Решение задания #4122.
* @author Viatcheslav Bugakov
* @version $id$
* @since 0.1
*/

public class CalculateTest {
    /**
    * Test method echo.
    */
    
    @Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Viatcheslav Bugakov";
    String expect = "Echo, echo, echo : Viatcheslav Bugakov"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
}
