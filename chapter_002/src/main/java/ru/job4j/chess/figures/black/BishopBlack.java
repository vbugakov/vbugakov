package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Class BishopBlack - realisation of moving rules of Black Bishop
 * task: Каркас шахматной доски [#792]
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov(gered@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(source.y - dest.y)];
        int deltaX = dest.x > source.x ? 1 : -1;
        int deltaY = dest.y > source.y ? 1 : -1;
        if (source.y - source.x != dest.y - dest.x && (7 - (source.x + source.y)) != (7 - (dest.x + dest.y))) {
            throw new ImpossibleMoveException();
        }
        for (int i = 0; i < steps.length; i++) {
            steps[i] = i == 0 ? this.findBy(source.x + deltaX, source.y + deltaY) : this.findBy(steps[i - 1].x + deltaX, steps[i - 1].y + deltaY);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
