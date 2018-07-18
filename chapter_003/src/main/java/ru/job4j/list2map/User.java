package ru.job4j.list2map;

/**
 * Class User -  solution of task:
 * 2. Написать программу преобразования List в Map. [#10093]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class User {
   private Integer id;
   private String city;
   private String name;

   User(Integer id, String city, String name) {
       this.id = id;
       this.city = city;
       this.name = name;
   }

   public Integer getId() {
       return this.id;
   }
}
