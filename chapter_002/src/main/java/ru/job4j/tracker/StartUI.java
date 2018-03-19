package ru.job4j.tracker;

import java.time.LocalDate;

/**
 * Class StartUI -  solution of task:
 * 1. Используя класс ConsoleInput в классе StartUI обеспечить полноценную работу всего приложения [#784]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class StartUI {

    /**
     * Constants of class for menu items
     * 0. Add new Item
     * 1. Show all items
     * 2. Edit item
     * 3. Delete item
     * 4. Find item by Id
     * 5. Find items by name
     * 6. Exit Program
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    /**
     * Variables of class
     * input - object for input
     * tracker - object for storage of items
     */
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer.trim())) {
                this.createItem();
            } else if (SHOW.equals(answer.trim())) {
                this.showAllItems();
            } else if (EDIT.equals(answer.trim())) {
                this.editItem();
            } else if (DEL.equals(answer.trim())) {
                this.deleteItem();
            } else if (FINDID.equals(answer.trim())) {
                this.findItemByID();
            } else if (FINDNAME.equals(answer.trim())) {
                this.findItemByName();
            } else if (EXIT.equals(answer.trim())) {
                exit = true;
            } else {
                this.showErrorMessage();
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявкики --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");

    }


    /**
     * Метод реализует редактирование заявки в хранилище
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявкики --------------");
        String name = this.input.ask("Введите имя заявки, которую хотите отредактировать :");
        Item[] findedItems = tracker.findByName(name);
        if (findedItems.length > 0) {
            System.out.println("Заявка найдена ID :" + findedItems[0].getId() + " Имя :" + findedItems[0].getName()
                    + " Описание : " + findedItems[0].getDescription());
            String newname = this.input.ask("Введите новое имя заявки :");
            String newdesc = this.input.ask("Введите новое описание заявки :");
            Item newitem = new Item(newname, newdesc, System.currentTimeMillis());
            tracker.replace(findedItems[0].getId(), newitem);
            System.out.println("Заявка с ID : " + newitem.getId() + " изменена Имя : " + newitem.getName()
                    + " Описание : " + newitem.getDescription());
        } else {
            System.out.println("Заявка с таким именем не найдена.");
        }
    }

    /**
     * Метод реализует вывод всех записей в хранилище
     */
    private void showAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        System.out.println("Ключ | Имя | Описание");
        for (Item item : tracker.findAll()) {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getDescription());
        }
        System.out.println("------------ Конец списка -----------");
    }

    /**
     * Метод реализует удаление заявки из хранилища
     */
    private void deleteItem() {
        System.out.println("------------ Удаление Заявки --------------");
        String id = this.input.ask("Введите  ключ заявки, которую хотите удалить :");
       if (tracker.findById(id) != null) {
           Item prey = tracker.findById(id);
           tracker.delete(id);
           System.out.println("Заявка успешно удалена Ключ :" + prey.getId() + " Имя :" + prey.getName()
                   + " Описание : " + prey.getDescription());
       } else {
           System.out.println("Заявка с таким ключом не найдена.");
       }
    }

    /**
     * Метод реализует поиск заявки в хранилище по ключу
     */
    private void findItemByID() {
        System.out.println("------------ Поиск заявки по ключу --------------");
        String id = this.input.ask("Введите  ключ заявки, которую хотите найти :");
        if (tracker.findById(id) != null) {
            System.out.println("Заявка успешно найдена Ключ :" + tracker.findById(id).getId()
                    + " Имя :" + tracker.findById(id).getName()
                    + " Описание : " + tracker.findById(id).getDescription());
        } else {
            System.out.println("Заявка с таким ключом не найдена.");
        }
    }

    /**
     * Метод реализует поиск заявки в хранилище по имени
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки, которую хотите найти :");
        Item[] findedItems = tracker.findByName(name);
        if (findedItems.length > 0) {
            if (findedItems.length == 1) {
                System.out.println("Заявка найдена Ключ :" + findedItems[0].getId() + " Имя :" + findedItems[0].getName()
                        + " Описание : " + findedItems[0].getDescription());
            }
            if (findedItems.length > 1) {
                System.out.println("Найдено " + findedItems.length + " заявок :");
                System.out.println("Ключ | Имя | Описание");
                for (Item item : findedItems) {
                    System.out.println(item.getId() + " | " + item.getName() + " | " + item.getDescription());
                }
            }
        } else {
            System.out.println("Заявка с таким именем не найдена.");
        }
    }



    private void showMenu() {

        System.out.println("Меню.");
        System.out.println("0. Добавить заявку.\n"
                + "1. Показать все заявки.\n"
                + "2. Отредакировать заявку.\n"
                + "3. Удалить заявку.\n"
                + "4. Найти заявку по ключу.\n"
                + "5. Найти заявку по имени.\n"
                + "6. Выйти из программы.");

    }

    private void showErrorMessage() {
        System.out.println("Ввод должен быть от 0 до 6");
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
