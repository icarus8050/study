package item_18;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class InstrumentedHashSetTest {

    @Test
    public void 잘못된_예제_테스트() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("하나", "둘", "셋"));

        System.out.println("this count is : " + s.getAddCount());
    }

    @Test
    public void 컴포지션을_활용한_예제() {
        InstrumentedSet<String> s = new InstrumentedSet<>(new TreeSet<>());
        s.add("하나");
        s.add("둘");
        s.add("셋");
        s.addAll(Arrays.asList("넷", "다섯", "여섯"));
        System.out.println("this count is : " + s.getAddCount());
    }

}