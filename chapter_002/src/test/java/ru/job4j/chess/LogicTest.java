package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class LogicTest - for testing methods of class Logic
 * task: Каркас шахматной доски [#792]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class LogicTest {

    @Test
    public void whenFigureNotFoundThenException() {
        Logic logic = new Logic();
        StringBuilder result = new StringBuilder();
        logic.add(new PawnBlack(Cell.A5));
        try {
            logic.move(Cell.A6, Cell.A5);
        } catch (RuntimeException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", new FigureNotFoundException().getClass().getSimpleName())));
    }

    @Test
    public void whenImpossibleMoveThenException() {
        Logic logic = new Logic();
        StringBuilder result = new StringBuilder();
        logic.add(new PawnBlack(Cell.A5));
        try {
            logic.move(Cell.A5, Cell.B5);
        } catch (RuntimeException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", new ImpossibleMoveException().getClass().getSimpleName())));
    }

    @Test
    public void whenOccupiedWayThenException() {
        Logic logic = new Logic();
        StringBuilder result = new StringBuilder();
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new BishopBlack(Cell.A6));
        try {
            logic.move(Cell.A7, Cell.A5);
        } catch (RuntimeException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", new OccupiedWayException().getClass().getSimpleName())));
    }

    @Test
    public void whenNoExceptionThenTrue() {
        Logic logic = new Logic();
        StringBuilder result = new StringBuilder();
        logic.add(new PawnBlack(Cell.A7));
        try {
            result.append(logic.move(Cell.A7, Cell.A5));
        } catch (RuntimeException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", true)));
    }

}