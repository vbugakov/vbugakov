package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PawnBlackTest - for testing methods of class PawnBlack
 * task: Каркас шахматной доски [#792]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class PawnBlackTest {

    @Test
    public void whenPositionThenReturnPosition() {
        Figure pawn = new PawnBlack(Cell.A6);
        Cell result = pawn.position();
        assertThat(result.toString(), is("A6"));
    }

    /**
     * methode .way section
     *
     */
    @Test
    public void whenWayIsCorrectThenReturnCells() {
        PawnBlack pawn = new PawnBlack(Cell.A7);
                StringBuilder result = new StringBuilder();
        try {
            Cell[] pawnway = pawn.way(Cell.A7, Cell.A6);
            for (Cell cell: pawnway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s ", "A6")));
    }

    @Test
    public void whenWayIsCorrectFirstMoveThenReturnCells() {
        PawnBlack pawn = new PawnBlack(Cell.A7);
        StringBuilder result = new StringBuilder();
        try {
            Cell[] pawnway = pawn.way(Cell.A7, Cell.A5);
            for (Cell cell: pawnway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s %s ", "A6", "A5")));
    }

    @Test
    public void whenWayIsIncorrectThenThrowsException() {
        PawnBlack pawn = new PawnBlack(Cell.A5);
        StringBuilder result = new StringBuilder();
        try {
            pawn.way(Cell.A5, Cell.A7);
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", new ImpossibleMoveException().getClass().getSimpleName())));
    }

    @Test
    public void whenCopyThenReturnsNewObject() {
        Figure pawn = new PawnBlack(Cell.A6);
        Figure result = pawn.copy(Cell.A7);
        assertThat(result.equals(pawn), is(false));
    }
}