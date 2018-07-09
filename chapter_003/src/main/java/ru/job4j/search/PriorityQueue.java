package ru.job4j.search;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Class PriorityQueue -  solution of task:
 * 2. Очередь с приоритетом на LinkedList [#41670]
 *
 * @author Petr Arsentev (parsentev@yandex.ru), Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    private Comparator<Task> compareTask = new Comparator<Task>() { // на лямбду пока менять не стал
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getPriority() - task2.getPriority();
        }
    };

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {

        if (tasks.isEmpty()) {
            tasks.add(0, task); //можно использовать .addFirst(task)
        } else {
            int size = this.tasks.size();
            for (int i = 0; i < size; i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    Task buffer = tasks.get(i);
                    tasks.set(i, task);
                    tasks.add(i + 1, buffer); //можно использовать .addLast(task)
                }
            }
        }
    }

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * То же самое но с использованием возможностей Компаратора.
     * @param task задача
     */
    public void putSE(Task task) {
        tasks.addFirst(task);
        Collections.sort(tasks, compareTask);
    }

    public Task take() {
        return this.tasks.poll();
    }
}

