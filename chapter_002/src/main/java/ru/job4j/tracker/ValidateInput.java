package ru.job4j.tracker;

/**
 * Class ValidateInput -  solution of task:
 * 1. Обеспечить бесперебойную работу приложения Tracker. [#789]
 * + Рефакторинг - Шаблон Декоратор для валидатора. [#34117]
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ValidateInput implements Input {
    private final Input input;

    public  ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    @Override
    public int ask(String question, int[] range) {
        int value = -1;
        boolean isWrong = true;
        do {
            try {
                value = this.input.ask(question, range);
                isWrong = false;
            } catch (MenuOutException mex) {
                System.out.println(mex.getMessage());
            } catch (NumberFormatException nex) {
                System.out.println("Введите число. Ввод должен быть от 0 до 6.");
            }
        } while (isWrong);
        return  value;
    }
}
