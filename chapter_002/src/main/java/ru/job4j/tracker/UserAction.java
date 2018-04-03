package ru.job4j.tracker;

public interface UserAction {
    int key();

    void execute(Tracker tracker, Input input);

}
