package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayDuplicateTest - for testing methods of class ArrayDuplicate
 * 5.5. Удаление дубликатов в массиве. [#225]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {
    /**
     * Test for method remove.
     * returns array with on duplicates corrected size sequence maybe changes
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] result = new ArrayDuplicate().remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    /**
     * Test for method remove.
     * No uniques case - return one element array.
     */
    @Test
    public void whenArrayWithNoUniqueThenArrayOneElement() {
        String[] result = new ArrayDuplicate().remove(new String[]{"Привет", "Привет", "Привет", "Привет", "Привет"});
        String[] expected = {"Привет"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}

