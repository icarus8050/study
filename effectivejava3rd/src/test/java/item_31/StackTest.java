package item_31;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void pushAll_메서드에_와일드카드_적용() {
        Stack<Number> stack = new Stack<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        stack.pushAll(integers);

        while (stack.getSize() != 0) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void 컨슈머_매개변수에_와일드카드_적용() {
        Stack<Number> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Collection<Object> objects = new ArrayList<>();
        stack.popAll(objects);

        objects.forEach(System.out::println);
    }
}