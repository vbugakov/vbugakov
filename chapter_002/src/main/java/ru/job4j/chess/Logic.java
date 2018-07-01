package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Class Logic - contains array of figures and checking of move possibility.
 * task: Каркас шахматной доски [#792]
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov(gered@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        Cell[]steps = new Cell[0];
        int index = this.findBy(source);


        if (index == -1) {
            throw new FigureNotFoundException();
        }

        if (index >= 0) {
            steps = this.figures[index].way(source, dest);
            int occupant = this.findBy(steps);
            if (occupant >= 0) {
                throw new OccupiedWayException();
            }
        }

        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell[] steps) {
        int result = -1;
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                result = this.findBy(step);
                break;
            }
        }
        return result;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
