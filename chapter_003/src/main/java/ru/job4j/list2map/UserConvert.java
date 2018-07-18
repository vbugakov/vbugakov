package ru.job4j.list2map;

import java.util.List;
import java.util.HashMap;
/**
 * Class UserConvert -  solution of task:
 * 2. Написать программу преобразования List в Map. [#10093]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class UserConvert {
    /**
     * В классе UserConvert написать метод public HashMap<Integer, User> process(List<User> list) {},
     * который принимает в себя список пользователей и конвертирует его в
     * Map с ключом Integer id и соответствующим ему User.
     * @param list - list for conversion
     *
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User entry : list) {
            result.put(entry.getId(), entry);
        }
        return result;
    }
}
