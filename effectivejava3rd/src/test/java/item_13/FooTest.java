package item_13;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FooTest {

    @Test
    public void fooCloneTest() {
        Foo first = new Foo(1, 2);
        Foo second = first.clone();

        System.out.println(first);
        System.out.println(second);
        System.out.println(first.equals(second));
    }
}