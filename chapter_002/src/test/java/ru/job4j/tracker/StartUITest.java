package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest - for testing methods of class StartUI
 * task: 3. Используя класс StubInput написать тесты проверяющие поведение пользователя [#785]:
 * 3. Тест-методы должны вместо пользователя выбирать пункты меню, вводить необходимые данные и выходить из приложения, после этого проверить изменение данных в Tracker;
 * 4. Необходимо написать тесты на все пункты меню, кроме вывода информации на консоль.
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

/**
 * Constants of class for menu items
 * 0. Add new Item
 * 2. Edit item
 * 3. Delete item
 * 6. Exit Program
 */
public class StartUITest {

    /**
     * test for Add new item
     * Метод реализует добавленяи новый заявки в хранилище.
     */

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "description", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getName(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteItemThenTrackerSizeReducedBy1() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 3; i++) {
            tracker.add(new Item("name" + i, "description", System.currentTimeMillis()));
        }
        int expected = tracker.findAll().length - 1;
        Input input = new StubInput(new String[]{"3", tracker.findByName("name1")[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(expected));
    }




}