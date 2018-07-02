package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BishopBlackTest - for testing methods of class BishopBlack
 * task: Каркас шахматной доски [#792]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class BishopBlackTest {

    @Test
    public void whenPositionThenReturnPosition() {
        Figure bishop = new BishopBlack(Cell.A6);
        Cell result = bishop.position();
        assertThat(result.toString(), is("A6"));
    }

    /**
     * methode .way section
     *
     */
    @Test
    public void whenWayIsCorrectNorthEastThenReturnCells() {
        Figure bishop = new BishopBlack(Cell.F6);
        StringBuilder result = new StringBuilder();
        try {
            Cell[] bishopway = bishop.way(Cell.F6, Cell.D4);
            for (Cell cell: bishopway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s %s ", "E5", "D4")));
    }

    @Test
    public void whenWayIsCorrectNorthWestThenReturnCells() {
        Figure bishop = new BishopBlack(Cell.F6);
        StringBuilder result = new StringBuilder();
        try {
            Cell[] bishopway = bishop.way(Cell.F6, Cell.H4);
            for (Cell cell: bishopway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s %s ", "G5", "H4")));
    }

    @Test
    public void whenWayIsCorrectSouthWestThenReturnCells() {
        Figure bishop = new BishopBlack(Cell.C6);
        StringBuilder result = new StringBuilder();
        try {
            Cell[] bishopway = bishop.way(Cell.C6, Cell.A8);
            for (Cell cell: bishopway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s %s ", "B7", "A8")));
    }

    @Test
    public void whenWayIsCorrectSouthEastThenReturnCells() {
        Figure bishop = new BishopBlack(Cell.B6);
        StringBuilder result = new StringBuilder();
        try {
            Cell[] bishopway = bishop.way(Cell.B6, Cell.D8);
            for (Cell cell: bishopway) {
                result.append(cell);
                result.append(" ");
            }
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s %s ", "C7", "D8")));
    }



    @Test
    public void whenWayIsIncorrectThenThrowsException() {
        Figure bishop = new BishopBlack(Cell.A8);
        StringBuilder result = new StringBuilder();
        try {
            bishop.way(Cell.A8, Cell.A7);
        } catch (ImpossibleMoveException e) {
            result.append(e.getClass().getSimpleName());
        }
        assertThat(result.toString(), is(String.format("%s", new ImpossibleMoveException().getClass().getSimpleName())));
    }

    @Test
    public void whenCopyThenReturnsNewObject() {
        Figure bishop = new BishopBlack(Cell.A6);
        Figure result = bishop.copy(Cell.A7);
        assertThat(result.equals(bishop), is(false));
    }
}