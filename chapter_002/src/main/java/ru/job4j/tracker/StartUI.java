package ru.job4j.tracker;



/**
 * Class StartUI -  solution of task:
 * 1. Используя класс ConsoleInput в классе StartUI обеспечить полноценную работу всего приложения [#784]
 * + Реализовать события на внутренних классах. [#787]
 * + Обеспечить бесперебойную работу приложения Tracker. [#789]
 * + Рефакторинг - Шаблон Декоратор для валидатора. [#34117]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class StartUI {
    /**
     * Variables of class
     * input - object for input
     * tracker - object for storage of items
     */
    private final Input input;
    private final Tracker tracker;


    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(tracker, input);
        do {
            menu.snowMenu();
            int answer = this.input.ask("Введите пункт меню : ", menu.getMenuRange());
            menu.select(answer);
        } while (!menu.getExit());
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    /**
     * Запускт программы.
     * @param args
     */

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
