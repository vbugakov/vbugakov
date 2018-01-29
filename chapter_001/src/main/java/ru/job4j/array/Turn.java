package ru.job4j.array;

/**
 * Class Turn -  solution of task:
 * 5.2. Перевернуть массив. [#4441]
 * @author Viatcheslav Bugakov
 * @version %Id%
 * @since 0.1
 */
public class Turn {
    /**
     * method back
     * @param array -  array for turn
     * @return turned array.
     */
    public int[] back(int[] array) {
        int buffer;
            for (int i = 0; i < array.length / 2; i++) {
                buffer = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = buffer;
            }
        return array;
    }
}
