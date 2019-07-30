package item_17.protected_pack;

public class Bar {
    private Foo foo;

    public Bar(Foo foo) {
        this.foo = foo;
    }

    public int getFooData() {
        Com com = new Com(5);
        return foo.data;
    }

    private static class Com {
        private int data;

        private Com(int data) {
            this.data = data;
        }
    }
}
