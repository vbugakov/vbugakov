package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;


/**
 * Class SortUserTest - for testing methods of class SortUser
 * task:  1. Организовать сортировку User [#10034]
 * 2. Сортировка User с использованием Comparator [#10036]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class SortUserTest {


    @Test
    public void whenListInThenSortedByAgeSetOut() {
        Set<User> result = new SortUser().sortAgeAscending(
                new ArrayList<>(Arrays.asList(new User("Ivan", 35),
                        new User("Pavel", 20),
                        new User("Sergej", 18)))
        );
        assertThat(result.toString(), is("[{Sergej, 18}, {Pavel, 20}, {Ivan, 35}]"));
    }

    @Test
    public void whenListInThenSortedByNameLengthListOut() {
        List<User> result = new SortUser().sortNameLength(
                new ArrayList<>(Arrays.asList(new User("Сергей", 25),
                        new User("Иван", 20),
                        new User("Ян", 18)))
        );
        assertThat(result.toString(), is("[{Ян, 18}, {Иван, 20}, {Сергей, 25}]"));
    }
    /**
     *  Например:
     *
     * Сергей, 25 (лет)
     * Иван, 30
     * Сергей, 20
     * Иван, 25
     *
     * должно отсортироваться в
     * Иван 25
     * Иван 30
     * Сергей 20
     * Сергей 25
     *
     */
    @Test
    public void whenListInThenSortedByAllFieldsListOut() {
        List<User> result = new SortUser().sortByAllFields(
                new ArrayList<>(Arrays.asList(new User("Сергей", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Иван", 25)))
        );
        assertThat(result.toString(), is("[{Иван, 25}, {Иван, 30}, {Сергей, 20}, {Сергей, 25}]"));
    }
}