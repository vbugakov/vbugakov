package ru.job4j.tracker;

/**
 * Class MenuOutException -  solution of task:
 * 1. Обеспечить бесперебойную работу приложения Tracker. [#789]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
