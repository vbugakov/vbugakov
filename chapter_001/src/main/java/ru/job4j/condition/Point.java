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
     * @author Viatcheslav Bugakov
     * @param x
     * @param y
     */
   public Point(int x, int y){
       this.x = x;
       this.y = y;
   }

    /**
     * Method distanceTo.
     * @author Viatcheslav Bugakov
     * @param that - object Point
     * @return distance to next point
     */
   public double distanceTo (Point that){
        return -1D;
   }
}
