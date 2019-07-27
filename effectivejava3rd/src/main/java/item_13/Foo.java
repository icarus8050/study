package item_13;

public class Foo implements Cloneable {

    private int x;
    private int y;

    public Foo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Foo)) {
            return false;
        }
        Foo foo = (Foo) obj;
        return foo.x == this.x && foo.y == this.y;
    }

    @Override
    protected Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
