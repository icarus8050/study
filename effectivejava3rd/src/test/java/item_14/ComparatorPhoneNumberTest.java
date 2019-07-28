package item_14;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ComparatorPhoneNumberTest {

    @Test
    public void simpleCompareTest() {
        Set<PhoneNumber> treeSet = new TreeSet<>();
        treeSet.addAll(
                Arrays.asList(
                        new PhoneNumber(111, 222, 3333),
                        new PhoneNumber(111, 123, 3333),
                        new PhoneNumber(110, 333, 3333),
                        new PhoneNumber(210, 111, 1111)
                )
        );

        treeSet.stream().forEach(PhoneNumber -> System.out.println(PhoneNumber.toString()));
    }
}