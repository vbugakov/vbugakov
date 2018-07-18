package ru.job4j.list2map;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {

    private ArrayList<User> listForConversionIdUnique(int size) {
        ArrayList<User> result = new ArrayList<User>();
        for (int i = 0; i < size; i++) {
            result.add(new User(i, "City" + i, "number" + i));
        }
        return result;
    }

    private ArrayList<User> listForConvertionIdNonUnique(int size) {
        ArrayList<User> result = new ArrayList<User>();
        for (int i = 0; i < size; i++) {
            result.add(new User((i % 3 == 0) ? i : i + 1, "City" + i, "number" + i));
        }
        return result;
    }

    /**
     * Unique Id section
     */
    @Test
    public void whenIdUniqueThenElementContainsInMapIsEqualToElementInList() {
        ArrayList<User> arr = listForConversionIdUnique(10);
        HashMap<Integer, User> result = new UserConvert().process(arr);
        assertThat(result.get(arr.get(2).getId()).equals(arr.get(2)), is(true));
    }
    @Test
    public void whenIdUniqueThenListSizeEqualMapSize() {
        ArrayList<User> arr = listForConversionIdUnique(10);
        HashMap<Integer, User> result = new UserConvert().process(arr);
        assertThat(result.size() == arr.size(), is(true));
    }
    /**
     * Duplicates Id section, HashMap not allowed duplicates
     */

    @Test
    public void whenIdNonUniqueThenDuplicateReplacedByOtherObjectWithSameId() {
        ArrayList<User> arr = listForConvertionIdNonUnique(10);
        HashMap<Integer, User> result = new UserConvert().process(arr);
        assertThat(result.get(arr.get(2).getId()).equals(arr.get(2)), is(false));
    }

    @Test
    public void whenIdNonUniqueThenDuplicatesNotAllowedInHashMap() {
        ArrayList<User> arr = listForConvertionIdNonUnique(10);
        HashMap<Integer, User> result = new UserConvert().process(arr);
        assertThat(result.size() == arr.size(), is(false));
    }


}