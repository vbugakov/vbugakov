package ru.job4j.condition;

/**
 * Class PointManualTest - for manual testing of class Point
 * from task 2.4. Расстояние между точками в системе координат. [#188]
 * @author Viatcheslav Bugakov
 * @version $Id$
 * @since 0.1
 */
public class PointManualTest {

    /**
     * Constants block of manual testing class contains coordinates of points:
     * x of point 1 {@value #X1}
     * x of point 2 {@value #X2}
     * y of point 1 {@value #Y1}
     * y of point 2 {@value #Y2}
     */
    public static final int X1 = 1;//constant x of point 1
    public static final int Y1 = 2;//constant y of point 1
    public static final int X2 = 3;//constant x of point 2
    public static final int Y2 = 4;//constant y of point 2

    /**
     * Method main - start point of a test.
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(X1,Y1);
        Point b = new Point(X2,Y2);
        a.distanceTo(b);
    }
}
