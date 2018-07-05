package ru.job4j.coffeemachine;

/**
 * Class CoffeeMachine  -  solution of task:
 * 2. Реализовать класс Tracker [#396]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */
/*
 * Надо реализовать метод выдачи сдачи для автомата.
 * int[] changes(int value, int price)
 * value = купюра. 50 100 и тд.
 * price = цена кофе
 * в автомате монеты наминалом 1 2 5 10
 * Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу автомат должен дать 15 рублей
 * Алгоритм должен вернуть наименьшее количество монет.
 * Метод вернет массив {10, 5} = 15 рублей
 *
 */

public class CoffeeMachine {
    private Money money = new Money();

    int[] changes(int value, int price) {
        int[] result = new int[0];
        try {
            int changeAmount = money.validateMoney(value) - price;
            int coinsIndex = money.getCoins().length - 1;
            result = new int[arraySize(changeAmount)];
            for (int i = 0; i < result.length; i++) {
                if (changeAmount < money.getCoins()[coinsIndex]) {
                    while (changeAmount < money.getCoins()[coinsIndex]) {
                        coinsIndex--;
                    }
                }
                result[i] = money.getCoins()[coinsIndex];
                changeAmount -= money.getCoins()[coinsIndex];
            }
        } catch (NoSuchNominal e) { }
        return  result;
    }

    private int arraySize(int change) {
        int size = 0;
        for (int i = money.getCoins().length - 1; i >= 0; i--) {
            if (change != 0) {
                size += change / money.getCoins()[i];
                change -= (change / money.getCoins()[i]) * money.getCoins()[i];
            }
        }
        return size;
    }

}
