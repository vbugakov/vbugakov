package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;


/**
 * Class SortUserTest - for testing methods of class SortUser
 * task:  1. Организовать сортировку User [#10034]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class SortUserTest {


    @Test
    public void whenListInThenSortedByAgeSetOut() {
        Set<User> result = new SortUser().sort(
                new ArrayList<>(Arrays.asList(new User("Ivan", 35),
                        new User("Pavel", 20),
                        new User("Sergej", 18)))
        );
        assertThat(result.toString(), is("[{Sergej, 18}, {Pavel, 20}, {Ivan, 35}]"));
    }
}