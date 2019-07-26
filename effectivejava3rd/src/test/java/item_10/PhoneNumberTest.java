package item_10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PhoneNumberTest {

    @Test
    public void sameReferenceTest() {
        PhoneNumber phoneNumber_1 = new PhoneNumber(111, 222, 333);
        PhoneNumber phoneNumber_2 = phoneNumber_1;

        assertThat(phoneNumber_1.equals(phoneNumber_2), is(true));
    }

    @Test
    public void logicalEqualsTest() {
        PhoneNumber phoneNumber_1 = new PhoneNumber(111, 222, 333);
        PhoneNumber phoneNumber_2 = new PhoneNumber(111, 222, 333);

        assertThat(phoneNumber_1.equals(phoneNumber_2), is(true));
    }

    @Test
    public void 간단한_해쉬코드_확인() {
        PhoneNumber phoneNumber_1 = new PhoneNumber(111, 222, 3333);
        PhoneNumber phoneNumber_2 = new PhoneNumber(111, 222, 3333);
        System.out.println(phoneNumber_1.hashCode());
        System.out.println(phoneNumber_2.hashCode());
    }

    @Test
    public void 컬렉션_해쉬_테스트() {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(111, 222, 3333), "HelloWorld!");

        System.out.println(m.get(new PhoneNumber(111, 222, 3333)));
    }
}