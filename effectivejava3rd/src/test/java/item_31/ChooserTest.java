package item_31;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChooserTest {

    @Test
    public void 생산자_매개변수에_와일드카드타입() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Chooser<Number> chooser = new Chooser<>(integers);
        System.out.println(chooser.choose());
    }
}