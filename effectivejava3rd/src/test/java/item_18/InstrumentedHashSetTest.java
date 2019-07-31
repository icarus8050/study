package item_18;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InstrumentedHashSetTest {

    @Test
    public void 잘못된_예제_테스트() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("하나", "둘", "셋"));

        System.out.println("this count is : " + s.getAddCount());
    }

}