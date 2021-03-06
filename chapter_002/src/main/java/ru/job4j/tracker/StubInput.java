package ru.job4j.tracker;

/**
 * Class StubInput -  solution of task:
 * 3. Используя класс StubInput написать тесты проверяющие поведение пользователя [#785]
 * + Обеспечить бесперебойную работу приложения Tracker. [#789]
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        boolean isInRange = false;
        int value = Integer.valueOf(this.ask(question));
        for (int item :range) {
            if (value == item) {
                isInRange = true;
                break;
            }
        }
        if (!isInRange) {
            throw new MenuOutException("Ввод должен быть от 0 до 6.");
        }
        return value;
    }
}
