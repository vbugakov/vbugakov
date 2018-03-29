package ru.job4j.pseudo;

/**
 * Class Paint -  solution of task:
 * 4. Используя шаблон проектирования - стратегию [#786]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

}
