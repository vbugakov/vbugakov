package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class HouseTest - for testing methods of class House
 * task: 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */


public class HouseTest {
    @Test
    public void houseToStringPlusInheritance() {
        House house = new House("Baker street 216, London");
        String result = house.toString();
        String expected  = "House On : Baker street 216, London";
        assertThat(result, is(expected));
        assertTrue(house instanceof  Subject);
    }

    @Test
    public  void thenHouseNotStartedThenProjected() {
        House house = new House("Baker street 216, London");
        String result = house.getStage();
        String expected  = "project";
        assertThat(result, is(expected));
    }

    @Test
    public  void thenHouseStartedThenShowStage() {
        House house = new House("Baker street 216, London", "Basement");
        String result = house.getStage();
        String expected  = "Basement";
        assertThat(result, is(expected));
    }
}
