package ru.job4j.condition;
/**
 * Class Point - Realisation of Point in coordinate system with
 * capability of calculate distance to himself
 * from task 2.4. Расстояние между точками в системе координат. [#188]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */

public class Point {

    private int x;
    private int y;

    /**
     * Constructor.
     * @param x - x coordinate
     * @param y - y coordinate
     */
   public Point(int x, int y) {
       this.x = x;
       this.y = y;
   }

    /**
     * Method distanceTo.
     * @param that - object Point
     * @return distance to next point
     */
   public double distanceTo(Point that) {
       return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
   }
}
