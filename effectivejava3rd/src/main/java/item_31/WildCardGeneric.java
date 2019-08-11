package item_31;

import java.util.List;
import java.util.Objects;

public class WildCardGeneric {

    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }

        E result = null;
        for (E e : list) {
            if (result == null || result.compareTo(e) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }
}
