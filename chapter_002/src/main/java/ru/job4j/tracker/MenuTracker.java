package ru.job4j.tracker;



/**
 * Class MenuTracker -  solution of task:
 * Реализовать события на внутренних классах. [#787]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class MenuTracker {
    public static final int MENUSIZE = 7;
    public static final String MENUFORMAT = "%s. %s.%n";
    private Tracker tracker;
    private Input input;
    private static boolean exit;

    private UserAction[] actions = new UserAction[MENUSIZE];

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
        this.exit = false;
        this.fillMenu();
    }

    public boolean getExit() {
        return  this.exit;
    }

    public void fillMenu() {
        actions[0] = new AddItem();
        actions[1] = this.new ShowAllItems();
        actions[2] = this.new EditItem();
        actions[3] = this.new DeleteItem();
        actions[4] = this.new FindById();
        actions[5] = this.new FindByName();
        actions[6] = new MenuTracker.Exit();
    }
    public void select(String index) {
         actions[Integer.valueOf(index)].execute(tracker, input);
    }

    public void snowMenu() {
        System.out.println("Меню.");
        for (UserAction action:actions) {
            if (action != null) {
                System.out.print(action);
            }
        }

    }

    private class ShowAllItems implements UserAction {
        private String localName = "Показать все заявки";
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Список всех заявок --------------");
            System.out.println("Ключ | Имя | Описание");
            for (Item item : tracker.findAll()) {
                System.out.printf("%s | %s | %s%n", item.getId(), item.getName(), item.getDescription());
            }
            System.out.println("------------ Конец списка -----------");
        }

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

    private class EditItem implements UserAction {
        private String localName = "Отредакировать заявку";
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Редактирование заявкики --------------");
            String name = input.ask("Введите имя заявки, которую хотите отредактировать :");
            Item[] findedItems = tracker.findByName(name);
            if (findedItems.length > 0) {
                System.out.printf("Заявка найдена ID : %s Имя : %s Описание : %s %n",
                        findedItems[0].getId(), findedItems[0].getName(), findedItems[0].getDescription());
                String newname = input.ask("Введите новое имя заявки :");
                String newdesc = input.ask("Введите новое описание заявки :");
                Item newitem = new Item(newname, newdesc, System.currentTimeMillis());
                tracker.replace(findedItems[0].getId(), newitem);
                System.out.printf("Заявка с ID : %s изменена - Имя : %s Описание : %s%n",
                        newitem.getId(), newitem.getName(),  newitem.getDescription());
            } else {
                System.out.println("Заявка с таким именем не найдена.");
            }
        }

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

    private class DeleteItem implements UserAction {
        private String localName = "Удалить заявку";
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Удаление Заявки --------------");
            String id = input.ask("Введите  ключ заявки, которую хотите удалить :");
            if (tracker.findById(id) != null) {
                Item prey = tracker.findById(id);
                tracker.delete(id);
                System.out.printf("Заявка успешно удалена. Ключ : %s Имя : %s Описание : %s%n",
                        prey.getId(), prey.getName(), prey.getDescription());
            } else {
                System.out.println("Заявка с таким ключом не найдена.");
            }
        }

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

    private class FindById implements UserAction {
        private String localName = "Найти заявку по ключу";
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Поиск заявки по ключу --------------");
            String id = input.ask("Введите  ключ заявки, которую хотите найти :");
            if (tracker.findById(id) != null) {
                System.out.printf("Заявка успешно найдена. Ключ : %s Имя : %s Описание : %s%n",
                        tracker.findById(id).getId(), tracker.findById(id).getName(), tracker.findById(id).getDescription());
            } else {
                System.out.println("Заявка с таким ключом не найдена.");
            }
        }

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

    private class FindByName implements UserAction {
        private String localName = "Найти заявку по имени";
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки, которую хотите найти :");
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

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

    private static class Exit implements UserAction {
        private String localName = "Выйти из программы";
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            MenuTracker.exit = true;
        }

        @Override
        public String toString() {
            return String.format(MENUFORMAT, this.key(), localName);
        }
    }

}

class AddItem implements UserAction {
    private String localName = "Добавить заявку";

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Tracker tracker, Input input) {
        System.out.println("------------ Добавление новой заявкики --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.printf("------------ Новая заявка с getId : %s -----------%n", item.getId());
    }

    @Override
    public String toString() {
        return String.format(MenuTracker.MENUFORMAT, this.key(), localName);
    }
}
