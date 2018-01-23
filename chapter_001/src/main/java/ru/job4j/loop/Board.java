package ru.job4j.loop;

/**
 * Class Board - solution of task :
 * 4.3 Построить шахматную доску в псевдографике. [#13559]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * method paint .
     * @param width - width of board
     * @param height - height of board
     * @return string of board painted by chars:
     * example size 3x3:
     * x x
     *  x
     * x x
     */

    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 != 0) && (j % 2 != 0))) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
                // добавляем перевод на новую строку.
            screen.append(ln);
        }

        return screen.toString();
    }

}
