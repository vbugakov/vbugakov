package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class CoffeeMachineTest - for testing methods of class CoffeeMachineTest
 * task: Кофемашина. [#34741]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class CoffeeMachineTest {

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


    @Test
    public void whenInputFromTaskOutputFromTask() {
        int[] result = new CoffeeMachine().changes(50, 35);
        assertThat(result, is(new int[]{10, 5}));
    }
    @Test
    public void whenInputFromTaskThenSizeTwo() {
        int[] result = new CoffeeMachine().changes(50, 35);
        assertThat(result.length, is(2));
    }

    @Test
    public void whenNoSuchNominalThenSizeZero() {
        int[] result = new CoffeeMachine().changes(51, 35);
        assertThat(result.length, is(0));
    }

    @Test
    public void whenPriceThirtyTwoThenAllCoinsIn() {
        int[] result = new CoffeeMachine().changes(50, 32);
        assertThat(result, is(new int[]{10, 5, 2, 1}));
    }
}