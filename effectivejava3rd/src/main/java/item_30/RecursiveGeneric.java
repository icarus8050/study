package item_30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveGeneric {
    public static <E extends Comparable<E>> E max (Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1000, 5, 12, 41, 1, -5);
        Integer result = max(integers);
        System.out.println(result);
    }
}
