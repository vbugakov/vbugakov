package ru.job4j.chess.figures;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    default Cell findBy(int x, int y) {
        Cell rst = Cell.A1;
        for (Cell cell:Cell.values()) {
            if (cell.x == x && cell.y == y) {
                rst = cell;
            }
        }
        return rst;
    }

    Figure copy(Cell dest);

}
