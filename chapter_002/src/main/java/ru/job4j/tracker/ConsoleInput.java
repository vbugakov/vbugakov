package ru.job4j.tracker;

import java.util.Scanner;
/**
 * Class ConsoleInput -  solution of task:
 * 1. Используя класс ConsoleInput в классе StartUI обеспечить полноценную работу всего приложения [#784]
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
}
