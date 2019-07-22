package item_10;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * 추이성 테스트
 * x == y, y == z -> x == z
 */
public class TransitivityTest {

    @Test
    public void badTransitivityTest() {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        assertEquals(p.equals(cp), cp.equals(p));
    }
}