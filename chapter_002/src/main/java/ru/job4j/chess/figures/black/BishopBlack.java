package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
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
        if (source.y - source.x != dest.y - dest.x && (7 - (source.x + source.y)) != (7 - (dest.x + dest.y))) {
            throw new ImpossibleMoveException();
        }

        if (dest.x < source.x && dest.y < source.y) { // north west
            for (int i = 0; i < steps.length; i++) {
                steps[i] = this.findBy(source.x - 1 - i, source.y - 1 - i);
            }
        }
        
        if (dest.x > source.x && dest.y < source.y) { //north east
            for (int i = 0; i < steps.length; i++) {
                steps[i] = this.findBy(source.x + 1 + i, source.y - 1 - i);
            }
        }
        
        if (dest.x > source.x && dest.y > source.y) { // south west
            for (int i = 0; i < steps.length; i++) {
                steps[i] = this.findBy(source.x + 1 + i, source.y + 1 + i);
            }
        }
        
        if (dest.x < source.x && dest.y > source.y) { // south east
            for (int i = 0; i < steps.length; i++) {
                steps[i] = this.findBy(source.x - 1 - i, source.y + 1 + i);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
