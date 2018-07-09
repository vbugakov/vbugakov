package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PriorityQueueTest - for testing methods of class PriorityQueue
 * task: 2. Очередь с приоритетом на LinkedList [#41670]
 *
 * @author Petr Arsentev (parsentev@yandex.ru), Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenListOfPriorities() {
        StringBuilder result = new StringBuilder();
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        for (int i = 0; i < 4; i++) {
            try {
                result.append(String.format("%s ", queue.take().getDesc()));
            } catch (NullPointerException e) {
                result.append(String.format("%s ", "NPE"));
            }

        }
        assertThat(result.toString(), is("urgent middle low NPE "));
    }

    @Test
    public void whenHigherPriorityPuSE() {
        PriorityQueue queue = new PriorityQueue();
        queue.putSE(new Task("low", 5));
        queue.putSE(new Task("urgent", 1));
        queue.putSE(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenListOfPrioritiesPutSE() {
        StringBuilder result = new StringBuilder();
        PriorityQueue queue = new PriorityQueue();
        queue.putSE(new Task("low", 5));
        queue.putSE(new Task("urgent", 1));
        queue.putSE(new Task("middle", 3));
        for (int i = 0; i < 4; i++) {
            try {
                result.append(String.format("%s ", queue.take().getDesc()));
            } catch (NullPointerException e) {
                result.append(String.format("%s ", "NPE"));
            }

        }
        assertThat(result.toString(), is("urgent middle low NPE "));
    }
}