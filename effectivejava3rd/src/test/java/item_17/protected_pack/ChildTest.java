package item_17.protected_pack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChildTest {

    @Test
    public void 오버라이드테스트() {
        Parent parent = new Child();
        parent.print();
    }

}