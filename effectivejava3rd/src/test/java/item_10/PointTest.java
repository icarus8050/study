package item_10;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PointTest {

    @Test
    public void simpleEqualsTest() {
        Point point_1 = new Point(1, 2);
        Point point_2 = new Point(1, 2);

        System.out.println(point_1.equals(point_2));
        System.out.println(point_2.equals(point_1));
        assertEquals(point_1.equals(point_2), point_2.equals(point_1));
    }
}