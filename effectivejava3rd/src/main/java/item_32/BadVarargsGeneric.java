package item_32;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BadVarargsGeneric {

    static void dangerous(List<String>... stringLists) {
        List<Integer> integers = Collections.singletonList(41);
        Object[] objects = stringLists;
        objects[0] = integers;              //힙 오염 발생
        String s = stringLists[0].get(0);   //ClassCastException
    }

    public static void printVarargsString(String... strings) {
        System.out.println(strings.getClass().getSimpleName());
        System.out.println();
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        printVarargsString("a", "b", "c");
    }
}
