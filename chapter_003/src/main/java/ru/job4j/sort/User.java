package ru.job4j.sort;

/**
 * Class User -  solution of task:
 * 1. Организовать сортировку User [#10034]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return  String.format("{%s, %s}", name, age);
    }


}
