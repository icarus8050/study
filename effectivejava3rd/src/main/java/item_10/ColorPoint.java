package item_10;

import java.awt.*;

public class ColorPoint {
    private Point point;
    private Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return this.point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) obj;
        return cp.point.equals(this.point) && cp.color.equals(this.color);
    }
}
