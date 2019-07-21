package item_10;

import org.junit.Test;

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

}