package ru.job4j.loop;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest - for testing methods of class Board
 * task 4.3. Построить шахматную доску в псевдографике. [#13559]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class BoardTest {

    /**
     * Test of method paint .
     * Should return string of board painted by chars:
     * size 3x3
     * x x
     *  x
     * x x
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }
    /**
     * Test of method paint .
     * Should return string of board painted by chars:
     * size 3x3
     * x x x
     *  x x
     * x x x
     *  x x
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        //напишите здесь тест, проверяющий формирование доски 5 на 4.
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}
