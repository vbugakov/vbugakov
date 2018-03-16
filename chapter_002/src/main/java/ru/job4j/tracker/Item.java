package ru.job4j.tracker;

/**
 * Class Item -  solution of task:
 * 2. Реализовать класс Tracker [#396]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Item {

    /**
     * Fields of class
     * id - unique id of item
     * name - name of item.
     * description - description of item.
     * created - when item is created
     * comments - Comments to item.
     */
    private String id;
    private String name;
    private String description;
    private long created;
    private String comments;

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
    /**
     * geters and setters section
     *
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
