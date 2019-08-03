package item_17.protected_pack;

import lombok.Data;

@Data
public class SimpleDTO {
    int data;

    public Foo ofFoo() {
        return Foo.builder().data(50).build();
    }
}
