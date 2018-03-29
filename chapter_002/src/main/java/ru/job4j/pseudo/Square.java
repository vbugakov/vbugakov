package ru.job4j.pseudo;

/**
 * Class Square -  solution of task:
 * 4. Используя шаблон проектирования - стратегию [#786]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}
