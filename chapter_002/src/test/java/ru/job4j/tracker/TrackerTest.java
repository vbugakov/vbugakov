package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest - for testing methods of class Tracker
 * task: 2. Реализовать класс Tracker [#396]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class TrackerTest {
    /**
     * test for method add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * test for method delete
     */
    @Test
    public void whenDeleteElementThenSizeOfFindAllLengthMinusOne() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 5; i++) {
            tracker.add(new Item("test" + i, "desc" + i, 123L + i));
        }
       int expected = tracker.findAll().length - 1;
        String preyId = tracker.findByName("test1")[0].getId();
        tracker.delete(preyId);
        assertThat(tracker.findAll().length, is(expected));
    }

    /**
     * test for method replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * test for method findAll
     */
    @Test
    public void whenAddSixElementsThenFindAllLengthSix() {
        Tracker tracker = new Tracker();
        int expected = 6;
        for (int i = 0; i < expected; i++) {
            tracker.add(new Item("test" + i, "desc" + i, 123L + i));
        }
        assertThat(tracker.findAll().length, is(expected));
    }

    /**
     * Test for method findByName
     */
    @Test
    public void whenAddSixElementsAndThreeOfThemEqualNamesThenFindByNameLengthThree() {
        Tracker tracker = new Tracker();
        int expected = 6;
        for (int i = 0; i < expected; i++) {
            if (i % 2 == 0) {
                tracker.add(new Item("tos", "desc" + i, 123L + i));
            } else {
                tracker.add(new Item("test" + i, "desc" + i, 123L + i));
            }

        }
        assertThat(tracker.findByName("tos").length, is(expected - 3));
    }

    /**
     * tests for method findById
     */
    @Test
    public void whenFindElementByIdThenNameReturnedElementExpected() {
        Tracker tracker = new Tracker();
        int elements = 6;
        for (int i = 0; i < elements; i++) {
            tracker.add(new Item("test" + i, "desc" + i, 123L + i));
        }
        String expected = "test2";
        Item result = tracker.findById(tracker.findByName(expected)[0].getId());
        assertThat(result.getName(), is(expected));
    }

    @Test
    public void whenElementByIdNotPresentThenReturnNull() {
        Tracker tracker = new Tracker();
        Assert.assertNull(tracker.findById("someID"));
    }

}