package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class MoneyTest - for testing methods of class Money
 * task: Кофемашина. [#34741]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */


public class MoneyTest {

    @Test
    public void whenNominalPresentReturnsNominal() {
        StringBuilder result = new StringBuilder();
        try {
            result.append(new Money().validateMoney(10));
        } catch (NoSuchNominal e) {
            result.append(e);
        }

      assertThat(result.toString(), is(String.format("%s", 10)));
    }

    @Test
    public void whenNominalNonPresentReturnsNominal() {
        StringBuilder result = new StringBuilder();
        try {
            result.append(new Money().validateMoney(12));
        } catch (NoSuchNominal e) {
            result.append(e.getClass().getSimpleName());
        }

        assertThat(result.toString(), is(new NoSuchNominal().getClass().getSimpleName()));
    }

}