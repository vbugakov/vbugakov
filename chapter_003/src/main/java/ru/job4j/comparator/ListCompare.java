package ru.job4j.comparator;
import java.util.Comparator;
/**
 * Class ListCompare -  solution of task:
 * 3. Компаратор для строк. [#35008]
 *
 * @author Petr Arsentev (parsentev@yandex.ru), Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */



public class ListCompare implements Comparator<String> {
    /**
     *Вам нужно реализовать компаратор для сравнения двух массивов символов.
     *
     * Необходимо реализовать поэлементное сравнение двух списков,
     * т.е. сравниваем элементы двух списков, находящихся на одних и тех же позициях
     * (по одним и тем же индексом). Сравнение в лексикографическом порядке.
     *
     * В этом задании нельзя использовать метод String.compateTo.
     *
     * Вы можете использовать
     *
     * String.charAt(int index)
     *
     * Integer.compare(int left, int right),
     *
     * Character.compare(char left, char right);
     */

    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) - right.charAt(i) != 0) {
                rst = left.charAt(i) - right.charAt(i);
                break;
            }
        }
        if (rst == 0) {
            rst = left.length() - right.length();
        }
        return rst;
    }
}