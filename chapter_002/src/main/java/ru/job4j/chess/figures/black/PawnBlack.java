package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Class PawnBlack - realisation of moving rules of Black Pawn
 * task: Каркас шахматной доски [#792]
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov(gered@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];

        if (!(((source.y == 6 && source.y == dest.y + 2) || source.y == dest.y + 1) && source.x == dest.x)) {
            throw new ImpossibleMoveException();
        }

        if (((source.y == 6 && source.y == dest.y + 2) || source.y == dest.y + 1) && source.x == dest.x) {
            for (int i = 0; i < steps.length; i++) {
                steps[i] = this.findBy(source.x, source.y - 1 - i);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
