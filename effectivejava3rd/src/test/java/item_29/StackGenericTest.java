package item_29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StackGenericTest {

    @Test
    public void 불공변스텍() {
        StackGeneric<Number> stackGeneric = new StackGeneric<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        stackGeneric.pushAll(integers);
    }

    @Test
    public void 컨슈머_한정적와일드카드() {
        StackGeneric<Number> stackGeneric = new StackGeneric<>();
        stackGeneric.push(1);
        stackGeneric.push(2);
        stackGeneric.push(3);

        List<Object> objects = new ArrayList<>();
        stackGeneric.popAll(objects);
    }
}