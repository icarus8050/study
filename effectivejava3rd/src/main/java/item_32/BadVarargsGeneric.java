package item_32;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BadVarargsGeneric {

    static void dangerous(List<String>... stringLists) {
        List<Integer> integers = Collections.singletonList(42);
        Object[] objects = stringLists;
        String s = stringLists[0].get(0);
    }
}
