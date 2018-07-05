package ru.job4j.coffeemachine;

/**
 * Class Money -  solution of task:
 * Кофемашина. [#34741]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Money {
    private int[] money = new int[]{1, 2, 5, 10, 50, 100, 200, 500, 1000, 2000, 5000};
    private int[] coins = new int[]{1, 2, 5, 10};

    public int[] getCoins() {
        return this.coins;
    }


    public int validateMoney(int value) throws NoSuchNominal {
        int result = -1;
        for (int note: money) {
            if (note == value) {
                result = value;
            }
        }
        if (result == -1) {
            throw new NoSuchNominal();
        }
        return result;
    }

}
