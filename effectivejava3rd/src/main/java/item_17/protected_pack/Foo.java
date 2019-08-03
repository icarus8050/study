package item_17.protected_pack;

import lombok.Builder;

public class Foo {

    int data;
    String name = "abcd";

    @Builder
    public Foo(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public String getName() {
        return name;
    }
}
