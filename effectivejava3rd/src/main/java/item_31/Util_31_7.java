package item_31;

import java.util.Arrays;
import java.util.List;

public class Util_31_7 {
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        swap(list, 0, 5);
        list.forEach(System.out::println);
    }
}
