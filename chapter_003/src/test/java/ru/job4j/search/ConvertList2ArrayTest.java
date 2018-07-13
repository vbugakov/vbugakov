package ru.job4j.search;

import  java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;
import java.util.ArrayList;

/**
 * Class ConvertList2ArrayTest - for testing methods of class ConvertList2Array
 * task: 3. Конвертация ArrayList в двухмерный массив [#10035],
 * 1. Конвертация листа массивов в один лист Integer [#10037]
 *
 * @author Petr Arsentev (parsentev@yandex.ru),Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when5ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                3
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * В классе ConvertList из 3-го задания 1-го урока написать метод:
     * public List<Integer> convert (List<int[]> list)
     * В этом методе вы должны пройтись по всем элементам всех массивов в списке list и
     * добавить их в один общий лист Integer.
     * Массивы в списке list могут быть разного размера.
     *
     * Например:
     * list.add(new int[]{1, 2})
     * list.add(new int[]{3, 4, 5, 6})
     * List<Integer> result = convertList.convert(list)
     *
     * List<Integer> result будет содержать элементы: (1, 2, 3, 4, 5, 6)
     */
    @Test
    public void whenListOfArraysConvertToListThen6() {

        List<Integer> result = new ConvertList2Array().convert(Arrays.asList(new int[]{1, 2},
                new int[]{3, 4, 5, 6}));
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(result, is(expect));
    }
}