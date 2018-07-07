package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
/**
 * Class PhoneDictionary -  solution of task:
 * 1. Телефонный справочник на базе ArrayList [#41598]
 *
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     *
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().contains(key) || person.getName().contains(key)
                    || person.getSurname().contains(key) || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
