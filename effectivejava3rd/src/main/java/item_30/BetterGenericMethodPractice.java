package item_30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 타입 매개변수로 명시하여 메서드의 타입 체크 경고없이 컴파일이 가능해졌다.
 */
public class BetterGenericMethodPractice {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> s2 = new HashSet<>(Arrays.asList("one", "two", "three"));
        Set result = union(s1, s2);
        for (Object o : result) {
            System.out.println(o.toString());
        }
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
