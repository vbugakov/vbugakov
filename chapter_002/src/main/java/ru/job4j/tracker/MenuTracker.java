package ru.job4j.tracker;



import java.util.Arrays;
import  java.util.ArrayList;

/**
 * Class MenuTracker -  solution of task:
 * Реализовать события на внутренних классах. [#787]
 * + Рефакторинг - Перенести общие методы в абстрактный класс [#790]
 * оставил реализацию на внутренних классах как в задании #787
 * только одно действие Show All реализовал как анонимный класс
 * 3. Изменить программу Tracker из 2-го модуля [#10039]
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private static boolean exit;

    private ArrayList<BaseAction> actions = new ArrayList<BaseAction>();

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
        this.exit = false;
        this.fillMenu();
    }

    public boolean getExit() {
        return  this.exit;
    }
    public int[] getMenuRange() {
        int[] resultArray = new int[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
               resultArray[i] = actions.get(i).key();
        }
        return resultArray;
    }

    public void fillMenu() {
        actions.add(new AddItem(0, "Добавить заявку"));
        actions.add(new BaseAction(1, "Показать все заявки") {
            @Override
            public void execute(Tracker tracker, Input input) {
                System.out.println("------------ Список всех заявок --------------");
                System.out.println("Ключ | Имя | Описание");
                for (Item item : tracker.findAll()) {
                    System.out.printf("%s | %s | %s%n", item.getId(), item.getName(), item.getDescription());
                }
                System.out.println("------------ Конец списка -----------");
            }
        });
        actions.add(this.new EditItem(2, "Отредакировать заявку"));
        actions.add(this.new DeleteItem(3, "Удалить заявку"));
        actions.add(this.new FindById(4, "Найти заявку по ключу"));
        actions.add(this.new FindByName(5, "Найти заявку по имени"));
        actions.add(new MenuTracker.Exit(6, "Выйти из программы"));
    }
    public void select(int index) {
         actions.get(index).execute(tracker, input);
    }

    public void snowMenu() {
        System.out.println("Меню.");
        for (UserAction action:actions) {
            if (action != null) {
                System.out.print(action);
            }
        }

    }


    private class EditItem extends BaseAction {

        public  EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            System.out.println("------------ Редактирование заявкики --------------");
            String id = input.ask("Введите ID заявки, которую хотите отредактировать :");
            Item findedItem = tracker.findById(id);
            if (findedItem != null) {
                System.out.printf("Заявка найдена ID : %s Имя : %s Описание : %s %n",
                        findedItem.getId(), findedItem.getName(), findedItem.getDescription());
                String newname = input.ask("Введите новое имя заявки :");
                String newdesc = input.ask("Введите новое описание заявки :");
                Item newitem = new Item(newname, newdesc, System.currentTimeMillis());
                tracker.replace(findedItem.getId(), newitem);
                Item changedItem = tracker.findById(newitem.getId());
                System.out.printf("Заявка с ID : %s изменена - Имя : %s Описание : %s%n",
                        changedItem.getId(), changedItem.getName(),  changedItem.getDescription());
            } else {
                System.out.println("Заявка с таким ID не найдена.");
            }
        }

    }

    private class DeleteItem extends BaseAction {

        public  DeleteItem(int key, String name) {
            super(key, name);
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
    }

    private class FindById extends BaseAction {

        public  FindById(int key, String name) {
            super(key, name);
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
    }

    private class FindByName extends BaseAction {

        public  FindByName(int key, String name) {
            super(key, name);
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
    }

    private static class Exit extends BaseAction {

        public  Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Tracker tracker, Input input) {
            MenuTracker.exit = true;
        }
    }

}

class AddItem extends BaseAction {

    public  AddItem(int key, String name) {
        super(key, name);
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
}
