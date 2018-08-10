package ru.job4j.tracker;

import java.util.*;

/**
 * Class Tracker -  solution of task:
 * 2. Реализовать класс Tracker [#396]
 * 3. Изменить программу Tracker из 2-го модуля [#10039]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Tracker {
    /**
     * Fields of class
     * items - Array for storage objects Item
     * position - Index of array for new item.
     * RND - constance needs for id construction
     */
    private List<Item> items = new ArrayList<Item>();
    private static final Random RND = new Random();

    /**
     * Method for adding item to array
     * @param item - new item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Method for editing item in array
     *  должен заменить ячейку в массиве this.items.
     *  Для этого необходимо найти ячейку в массиве по id
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        boolean result = !(indexById(id) < 0);
        if (result) {
            this.items.set(indexById(id), item);
        }
        return  result;
    }

    /**
     * Method deleting item from array
     * должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью
     * System.arrayCopy();
     */
    public boolean delete(String id) {
        Item item = findById(id);
        boolean result = !(item == null);
        if (result) {
            items.remove(item);
        }
        return result;
    }

    /**
     * Method for receive list of all elements of items array what not null.
     * возвращает копию массива this.items без null элементов;
     * @return Array of items.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Method for finding items by name
     * проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий
     * массив и возвращает его;
     * @param key
     * @return array of items finned by name
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
       return result;
    }

    /**
     * Method for finding item by ID
     *  проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id
     *  и возвращает найденный Item. Если Item не найден - возвращает null.
     * @param id
     * @return item or null
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method for generation unique ID.
     * @return unique ID.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }

    /**
     * Methode indexById
     * @param id - id of element
     * @return index of element in array
     */
    private int indexById(String id) {
        int result = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = items.indexOf(item);
                break;
            }
        }
        return result;
    }
}
