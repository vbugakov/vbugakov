package ru.job4j.loop;
/**
 * Class Factorial - solution of task
 * 4.2. Создать программу вычисляющую факториал. [#193]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Factorial {


         /**
         * Method calc
         * @param n - number
         * @return factorial of n
         */
        public int calc(int n) {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }

