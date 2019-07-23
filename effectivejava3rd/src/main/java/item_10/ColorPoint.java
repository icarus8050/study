package item_10;

import java.awt.*;

public class ColorPoint extends Point {
    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) {
            return false;
        }
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        return super.equals(obj) && ((ColorPoint) obj).color == this.color;
    }
}
