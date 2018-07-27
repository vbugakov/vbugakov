package ru.job4j.sort;

import java.util.Comparator;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
/**
 * Class SortUser -  solution of task:
 * 1. Организовать сортировку User [#10034]
 * 2. Сортировка User с использованием Comparator [#10036]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class SortUser {
    /**
     * В классе SortUser написать метод public Set<User> sort (List<User>),
     * который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param users
     */

    public Set<User> sortAgeAscending(List<User> users) {
        return  new TreeSet<User>(users);
    }
    /**
     * 1) public List<User> sortNameLength (List<User>) - в этом методе необходимо определить Comparator
     * для метода Collections.sort и отсортировать List<User> по длине имени.
     * @param users
     */


    List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
       return users;
    }
    /**
     *2) public List<User> sortByAllFields (List<User>) - в этом методе необходимо определить Comparator
     *  для метода Collections.sort и отсортировать List<User> по обоим полям,
     *  сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     *
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
     * @param users
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rst = o1.getName().compareToIgnoreCase(o2.getName());
                if (rst == 0) {
                    rst = o1.getAge() - o2.getAge();
                }
                return rst;
            }
        });
     return users;
    }


}
