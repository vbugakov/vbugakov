package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Class PaintTest  -  for testing of class Paint
 * solution of task:
 * 4.4. Построить пирамиду в псевдографике. [#4412]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class PaintTest {

    /**
     * test for Method rightTrl - paints right Triangle
     *
     * ^
     * ^^
     * ^^^
     * ^^^^
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^   ")
                                .add("^^  ")
                                .add("^^^ ")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    /**
     * test for Method leftTrl - paints left Triangle
     *
     *    ^
     *   ^^
     *  ^^^
     * ^^^^
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }

    /**
     * test for Method pyramid - paints pyramid
     *
     *    ^
     *   ^^^
     *  ^^^^^
     * ^^^^^^^
     */

    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }

}
