package item_10;

import org.junit.Test;

import java.awt.*;

/**
 * 추이성 테스트
 * x == y, y == z -> x == z
 */
public class TransitivityTest {

    @Test
    public void badTransitivityTest() {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(p.equals(cp));   //true
        System.out.println(cp.equals(p));   //false
    }

    @Test
    public void 추이성_위배() {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLACK);

        System.out.println(p1.equals(p2));  //true
        System.out.println(p2.equals(p3));  //true
        System.out.println(p1.equals(p3));  //false
    }

    @Test
    public void 컴포지션_이용하여_equals() {
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
    }
}