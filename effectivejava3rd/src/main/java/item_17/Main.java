package item_17;

import item_17.protected_pack.Foo;
import item_17.protected_pack.SimpleDTO;

public class Main {

    public static void main(String[] args) {
        SimpleDTO simpleDTO = new SimpleDTO();
        simpleDTO.setData(50);

        Foo foo = simpleDTO.ofFoo();

        System.out.println(foo.getData());
        System.out.println(foo.getName());
    }
}
