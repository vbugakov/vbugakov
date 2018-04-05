package ru.job4j.tracker;

import java.util.Scanner;
/**
 * Class ConsoleInput -  solution of task:
 * 1. Используя класс ConsoleInput в классе StartUI обеспечить полноценную работу всего приложения [#784]
 * + Обеспечить бесперебойную работу приложения Tracker. [#789]
 * class intended for console input implements Interface Input
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ConsoleInput implements  Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
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
        if (isInRange) {
            return value;
        } else {
            throw new MenuOutException("Ввод должен быть от 0 до 6.");

        }
    }
}
