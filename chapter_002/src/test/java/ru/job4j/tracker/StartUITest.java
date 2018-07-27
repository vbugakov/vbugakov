package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

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


public class StartUITest {
    /**
     * Class fields:
     * stdout - standard output (to console)
     * out - output to memory
     */

    private String menu = showMenu();


    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Before tests
     */
    @Before
    public void outputToMemory() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * After Tests
     */
    @After
    public void outputToConsole() {
        System.setOut(stdout);
    }
    /**
     * Case:
     * 0. Добавить заявку.
     * проверка вывода
     */

    @Test
    public void whenAddItemOutput() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultAddItem(tracker)));
    }

    /**
     * Case:
     * 2. Отредакировать заявку.
     * проверка вывода
     */
    @Test
    public void whenEditPresentItemOutput() {
        Tracker tracker = new Tracker();
        StringBuilder expected = new StringBuilder();
        Item item = tracker.add(new Item("name", "description", System.currentTimeMillis()));
        expected.append(resultEditHead(tracker, item.getId()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        expected.append(resultEditTail(tracker, "test name", item.getId()));
        assertThat(out.toString(), is(expected.toString()));
    }

    @Test
    public void whenEditNonPresentItemOutput() {
        Tracker tracker = new Tracker();
        StringBuilder expected = new StringBuilder();
        Item item = tracker.add(new Item("namename", "description", System.currentTimeMillis()));
        expected.append(resultEditHead(tracker, "11111"));
        Input input = new StubInput(new String[]{"2", "11111", "6"});
        new StartUI(input, tracker).init();
        expected.append(resultEditTail(tracker, "11111", item.getId()));
        assertThat(new String(out.toByteArray()), is(expected.toString()));
    }

    /**
     * Case:
     * 3. Удалить заявку.
     * проверка вывода
     */
    @Test
    public void whenPresentItemDeletionOutput() {

        Tracker tracker = createFilledTracker(3, false, "name");
        String preyID = tracker.findByName("name1")[0].getId();
        String preyName = tracker.findByName("name1")[0].getName();
        String preyDesc = tracker.findByName("name1")[0].getDescription();
        Input input = new StubInput(new String[]{"3", preyID, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultDoneDelete(preyID, preyName, preyDesc)));
    }

    @Test
    public void whenNonPresentItemDeletionOutput() {

        Tracker tracker = createFilledTracker(3, false, "name");
        String preyID = "11111111";
        Input input = new StubInput(new String[]{"3", preyID, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFalseDelete()));
    }

    /**
     * Case:
     * 1.Показать все заявки
     * проверка вывода
     */
    @Test
    public void whenShowAllItemsOutput() {
        Tracker tracker = createFilledTracker(3, false, "name");
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultShowAll(tracker)));
    }

    /**
     * Case:
     * 5. Найти заявку по имени
     * проверка вывода
     */
    @Test
    public void whenFindItemByNameMultipleItemsOutput() {
        String nameToFind = "Name";
        Tracker tracker = createFilledTracker(4, true, nameToFind);
        Input input = new StubInput(new String[]{"5", nameToFind, "6"});

        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFindByName(tracker, nameToFind)));
    }

    @Test
    public void whenFindItemByNameOneItemOutput() {
        String nameToFind = "Name";
        Tracker tracker = createFilledTracker(2, true, nameToFind);
        Input input = new StubInput(new String[]{"5", nameToFind, "6"});

        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFindByName(tracker, nameToFind)));
    }

    @Test
    public void whenFindItemByNameNonPresentOutput() {

        Tracker tracker = createFilledTracker(6, true, "Name");
        String nameToFind = "Test Name";
        Input input = new StubInput(new String[]{"5", nameToFind, "6"});

        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFindByName(tracker, nameToFind)));
    }

    /**
     * Case:
     * 4.Найти заявку по ключу
     * проверка вывода
     */
    @Test
    public void whenFindPresentItemByIdOutput() {
        Tracker tracker = createFilledTracker(3, false, "name");
        String id = tracker.findAll()[1].getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFindById(tracker, id)));
    }

    @Test
    public void whenFindNonPresentItemsByIdOutput() {
        Tracker tracker = createFilledTracker(3, false, "name");
        String id = "111111";
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(out.toString(), is(resultFindById(tracker, id)));
    }

    /**
     * Service methods for result for build up
     * testing output
     *
     */
    private String resultAddItem(Tracker tracker) {
        StringBuilder result = new StringBuilder();
        result.append(menu);
        result.append("------------ Добавление новой заявкики --------------");
        result.append(System.lineSeparator());
        result.append(String.format("------------ Новая заявка с getId : %s -----------", tracker.findAll()[0].getId()));
        result.append(System.lineSeparator());
        result.append(menu);
        return result.toString();
    }
    private String resultShowAll(Tracker tracker) {
        StringBuilder result = new StringBuilder();
        result.append(menu)
              .append("------------ Список всех заявок --------------")
              .append(System.lineSeparator())
              .append("Ключ | Имя | Описание")
              .append(System.lineSeparator());
        for (Item item : tracker.findAll()) {
           result.append(String.format("%s | %s | %s", item.getId(), item.getName(), item.getDescription()));
           result.append(System.lineSeparator());
        }
        result.append("------------ Конец списка -----------")
              .append(System.lineSeparator())
              .append(menu);
        return result.toString();
    }
    private String resultEditHead(Tracker tracker, String id) {
        StringBuilder result = new StringBuilder();
        result.append(menu);
        result.append("------------ Редактирование заявкики --------------");
        result.append(System.lineSeparator());
        Item findedItem = tracker.findById(id);
        if (findedItem != null) {
            result.append(String.format("Заявка найдена ID : %s Имя : %s Описание : %s ",
                    findedItem.getId(), findedItem.getName(), findedItem.getDescription()));
            result.append(System.lineSeparator());
        } else {
            result.append("Заявка с таким ID не найдена.");
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
    private String resultEditTail(Tracker tracker, String name, String id) {
        StringBuilder result = new StringBuilder();
        if (tracker.findById(id).getName().equals(name)) {
            result.append("Заявка с ID : " + tracker.findByName(name)[0].getId() + " изменена - Имя : " + tracker.findByName(name)[0].getName()
                    + " Описание : " + tracker.findByName(name)[0].getDescription());
            result.append(System.lineSeparator());
        }
        result.append(menu);
        return result.toString();
    }
    private String resultDoneDelete(String id, String name, String desc) {
        StringBuilder result = new StringBuilder();
        result.append(menu);
        result.append("------------ Удаление Заявки --------------");
        result.append(System.lineSeparator());
        result.append(String.format("Заявка успешно удалена. Ключ : %s Имя : %s Описание : %s", id, name, desc));
        result.append(System.lineSeparator());
        result.append(menu);
        return result.toString();
    }
    private String resultFalseDelete() {
        StringBuilder result = new StringBuilder();
        result.append(menu);
        result.append("------------ Удаление Заявки --------------");
        result.append(System.lineSeparator());
        result.append("Заявка с таким ключом не найдена.");
        result.append(System.lineSeparator());
        result.append(menu);
        return result.toString();
    }
    private String resultFindById(Tracker tracker, String id) {
        StringBuilder result = new StringBuilder();
        result.append(menu);
        result.append("------------ Поиск заявки по ключу --------------");
        result.append(System.lineSeparator());
        if (tracker.findById(id) != null) {
            result.append(String.format("Заявка успешно найдена. Ключ : %s Имя : %s Описание : %s",
                    tracker.findById(id).getId(), tracker.findById(id).getName(), tracker.findById(id).getDescription()));
            result.append(System.lineSeparator());
        } else {
            result.append("Заявка с таким ключом не найдена.");
            result.append(System.lineSeparator());
        }
        result.append(menu);
        return  result.toString();
    }
    private String resultFindByName(Tracker tracker, String name) {
        StringBuilder result = new StringBuilder();
        Item[] findedItems = tracker.findByName(name);
        result.append(menu);
        result.append("------------ Поиск заявки по имени --------------");
        result.append(System.lineSeparator());

        if (findedItems.length > 0) {
            if (findedItems.length == 1) {
                result.append(String.format("Заявка найдена. Ключ: %s Имя: %s Описание: %s",
                        findedItems[0].getId(), findedItems[0].getName(), findedItems[0].getDescription()));
                result.append(System.lineSeparator());
            }
            if (findedItems.length > 1) {
                result.append(String.format("Найдено %s заявок :", findedItems.length));
                result.append(System.lineSeparator());
                result.append("Ключ | Имя | Описание");
                result.append(System.lineSeparator());
                for (Item item : findedItems) {
                    result.append(String.format("%s | %s | %s", item.getId(), item.getName(), item.getDescription()));
                    result.append(System.lineSeparator());
                }
            }
        } else {
            result.append("Заявка с таким именем не найдена.");
            result.append(System.lineSeparator());
        }
        result.append(menu);
        return result.toString();
    }
    private Tracker createFilledTracker(int size, boolean condition, String name) {
        Tracker tracker = new Tracker();
        if (condition) {
            for (int i = 0; i < size; i++) {
                if (i % 2 == 0) {
                    tracker.add(new Item(name, "description", System.currentTimeMillis()));
                } else {
                    tracker.add(new Item(name + i, "description", System.currentTimeMillis()));
                }

            }
        } else {
            for (int i = 0; i < size; i++) {
                tracker.add(new Item(name + i, "description", System.currentTimeMillis()));
            }

        }
        return tracker;
    }
    private String showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Меню.")
            .append(System.lineSeparator())
            .append("0. Добавить заявку.")
            .append(System.lineSeparator())
            .append("1. Показать все заявки.")
            .append(System.lineSeparator())
            .append("2. Отредакировать заявку.")
            .append(System.lineSeparator())
            .append("3. Удалить заявку.")
            .append(System.lineSeparator())
            .append("4. Найти заявку по ключу.")
            .append(System.lineSeparator())
            .append("5. Найти заявку по имени.")
            .append(System.lineSeparator())
            .append("6. Выйти из программы.")
            .append(System.lineSeparator());
        return sb.toString();
    }




}