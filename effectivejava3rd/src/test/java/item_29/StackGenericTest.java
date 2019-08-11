package item_29;

import org.junit.Test;

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

}