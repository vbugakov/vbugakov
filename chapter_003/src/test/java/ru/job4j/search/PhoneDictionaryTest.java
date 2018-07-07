package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PhoneDictionaryTest - for testing methods of class PhoneDictionary
 * task: 1. Телефонный справочник на базе ArrayList [#41598]
 *
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class PhoneDictionaryTest {
    /**
     * Например. Арсентьев, Петр, Брянск, 53742.
     * Если мы ищем по слово "нкс" или 537 или Арс.
     * Мы всегда должны вернуть этого пользователя.
     */

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
            new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPartCityName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("nsk");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}