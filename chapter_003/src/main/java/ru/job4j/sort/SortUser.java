package ru.job4j.sort;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
/**
 * Class SortUser -  solution of task:
 * 1. Организовать сортировку User [#10034]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class SortUser {
    /**
     * В классе SortUser написать метод public Set<User> sort (List<User>),
     * который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     */

    public Set<User> sort(List<User> users) {
        return  new TreeSet<User>(users);
    }
}
