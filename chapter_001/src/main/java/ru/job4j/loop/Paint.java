package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class Paint  -  solution of task:
 * 4.4. Построить пирамиду в псевдографике. [#4412]
 * and refactoring:
 * 4.5. Рефакторинг кода. [#33459]
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
        return this.loopBy(height, height, (row, column) -> row >= column);
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
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
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
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
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
