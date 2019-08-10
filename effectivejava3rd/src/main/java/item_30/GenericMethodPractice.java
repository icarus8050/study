package item_30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 메서드의 타입이 안전하지 않다.
 */
public class GenericMethodPractice {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<String> s2 = new HashSet<>(Arrays.asList("one", "two", "three"));
        Set result = union(s1, s2);
        for (Object o : result) {
            System.out.println(o.toString());
        }
    }

    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
