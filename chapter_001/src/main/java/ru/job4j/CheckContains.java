package ru.job4j;

import java.util.Arrays;

/**
 * Class CheckContains -  solution of task:
 * Проверка, что одно слово находится в другом слове [#228]
 * task description:
 * Создать программу проверяющую, что словo String находится в другом слове String.
 * В программе должен быть метод
 * boolean contains(String origin, String sub).
 * Нельзя использовать String.indexOf String.contains.
 * Нужно преобразовать строку в массив символов и проверить.
 *
 * Пример.
 *
 * String origin = "Привет";
 * String sub = "иве";
 *
 * boolean result = contains(origin, sub); - true - так как "иве" есть в слове "Привет".
 *
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class CheckContains {
    /**
     * method contains
     * @param origin -  word for analysis.
     * @param sub - word looking for
     * @return true if origin contains sub.
     */
    boolean contains(String origin, String sub) {
        boolean result = false;
        int matches = 0;
        char[] originArray = origin.toLowerCase().toCharArray();
        char[] subArray = sub.toLowerCase().toCharArray();
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] == subArray[0] && i <= originArray.length - subArray.length) {

                for (int j = 0, k = i; j < subArray.length; j++, k++) {
                    if (originArray[k] == subArray[j]) {
                        matches++;
                    }
                }

                if (matches == subArray.length) {
                    result = true;
                    break;
                } else {
                    matches = 0;
                }
            }
        }
        return result;
    }

    /**
     * method contains
     * Включите в список запретного regionMatches  тоже :)
     * @param origin -  word for analysis.
     * @param sub - word looking for
     * @return true if origin contains sub.
     */
    boolean containsCheat(String origin, String sub) {
        for (int i = 0; i < origin.length(); i++) {
            if (origin.regionMatches(true, i, sub, 0, sub.length())) {
                return true;
            }
        }
        return false;
    }
}
