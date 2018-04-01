package ru.job4j.tracker;



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
     * 5. Find item by name
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
        System.out.printf("------------ Новая заявка с getId : %s -----------%n", item.getId());

    }


    /**
     * Метод реализует редактирование заявки в хранилище
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявкики --------------");
        String name = this.input.ask("Введите имя заявки, которую хотите отредактировать :");
        Item[] findedItems = tracker.findByName(name);
        if (findedItems.length > 0) {
            System.out.printf("Заявка найдена ID : %s Имя : %s Описание : %s %n",
                    findedItems[0].getId(), findedItems[0].getName(), findedItems[0].getDescription());
            String newname = this.input.ask("Введите новое имя заявки :");
            String newdesc = this.input.ask("Введите новое описание заявки :");
            Item newitem = new Item(newname, newdesc, System.currentTimeMillis());
            tracker.replace(findedItems[0].getId(), newitem);
            System.out.printf("Заявка с ID : %s изменена - Имя : %s Описание : %s%n",
                    newitem.getId(), newitem.getName(),  newitem.getDescription());
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
            System.out.printf("%s | %s | %s%n", item.getId(), item.getName(), item.getDescription());
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
           System.out.printf("Заявка успешно удалена. Ключ : %s Имя : %s Описание : %s%n",
                   prey.getId(), prey.getName(), prey.getDescription());
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
            System.out.printf("Заявка успешно найдена. Ключ : %s Имя : %s Описание : %s%n",
                    tracker.findById(id).getId(), tracker.findById(id).getName(), tracker.findById(id).getDescription());
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
                System.out.printf("Заявка найдена. Ключ: %s Имя: %s Описание: %s%n",
                        findedItems[0].getId(), findedItems[0].getName(), findedItems[0].getDescription());
            }
            if (findedItems.length > 1) {
                System.out.printf("Найдено %s заявок :%n", findedItems.length);
                System.out.println("Ключ | Имя | Описание");
                for (Item item : findedItems) {
                    System.out.printf("%s | %s | %s%n", item.getId(), item.getName(), item.getDescription());
                }
            }
        } else {
            System.out.println("Заявка с таким именем не найдена.");
        }
    }



    private void showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Меню.")
                .append(System.lineSeparator())
                .append("0. Добавить заявку.\n")
                .append("1. Показать все заявки.\n")
                .append("2. Отредакировать заявку.\n")
                .append("3. Удалить заявку.\n")
                .append("4. Найти заявку по ключу.\n")
                .append("5. Найти заявку по имени.\n")
                .append("6. Выйти из программы.")
                .append(System.lineSeparator());
        System.out.print(sb.toString());
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
