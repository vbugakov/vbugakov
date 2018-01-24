package ru.job4j.loop;

/**
 * Class Paint  -  solution of task:
 * 4.4. Построить пирамиду в псевдографике. [#4412]
 * @author Petr Arsentev (parsentev@yandex.ru)
 *         Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class Paint {
    /**
     * Method rightTrl - paints right Triangle
     * @param height - neight of triangle
     * @return String what paints:
     * ^
     * ^^
     * ^^^
     * ^^^^
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Method leftTrl - paints left Triangle
     * @param height - neight of triangle
     * @return String what paints:
     *    ^
     *   ^^
     *  ^^^
     * ^^^^
     */

    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= height - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Method pyramid - paints pyramid
     * @param height - neight of pyramid
     * @return String what paints:
     *    ^
     *   ^^^
     *  ^^^^^
     * ^^^^^^^
     */

    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
