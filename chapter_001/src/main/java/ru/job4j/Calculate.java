package ru.job4j;

/**
* class Calculate. Выводит строку Hello world! в консоль. Решение задания #141.
* @author Viatcheslav Bugakov
* @since 12.01.2018
*/

public class Calculate {
    /**
     * Method main.
     * @param String[] args.
     */
    
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
    
     /**
     * Method echo.
     * @param name Your name.
     * @return Echo(three times) and your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
