package ru.job4j.calculator;
/**
 * Class Calculator - Realisation of elementary
 * calculator from task 2.3. Элементарный калькулятор. [#185]
 * Includes homework methods.
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class Calculator {

    private double result;

    /**
     * Method add.
     * some kind of "setter" add second to first
     * and stores result to class field "result"
     * @author (Copy paste)
     *
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method sub
     * some kind of "setter" subtract second from first
     * and stores result to class field "result"
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method mult
     * some kind of "setter" multiplied second by first
     * and stores result to class field "result"
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    public void mult(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method div
     * some kind of "setter" divide first by second
     * and stores result to class field "result"
     * задание 2.3. Элементарный калькулятор.
     * @author Viatcheslav Bugakov
     *
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method getResult
     * Classical getter
     * @author (Copy paste)
     * @return result
     */
    public double getResult() {
        return  this.result;
    }
}
