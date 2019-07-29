package item_15;

import java.util.Arrays;

public class Main {

    public static final Integer[] arr = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Arrays.stream(arr).forEach(num -> System.out.println(num));

        arr[0] = Integer.valueOf(10);

        Arrays.stream(arr).forEach(num -> System.out.println(num));
    }
}
