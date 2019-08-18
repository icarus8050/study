package item_32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VarargsGenericUtil {

    /* 입력받은 제네릭 매개변수들을 배열로 감싸주어 유용한 유틸리티 메서드로 보이지만, 안전하지 않다. */
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(b, c);
            case 2: return toArray(a, c);
        }
        throw new AssertionError(); //도달할 수 없다.
    }

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("a", "b", "c");
    }
}
