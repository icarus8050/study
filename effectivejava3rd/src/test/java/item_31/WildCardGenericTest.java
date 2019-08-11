package item_31;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WildCardGenericTest {

    @Test
    public void 와일드카드제네릭_max() {
        List<Integer> integers = Arrays.asList(1000, 5, 12, 41, 1, -5);
        Integer result = WildCardGeneric.max(integers);
        System.out.println(result);
    }

    @Test
    public void 와일드카드제네릭_max_2() {
        Work job1 = new Job("코딩하기");
        Work job2 = new Job("스터디 가기");
        Work job3 = new Job("세미나 가기");

        List<ScheduledFuture<Work>> scheduledFutures = new ArrayList<>();
        scheduledFutures.add(new Schedule<>(0, job1));
        scheduledFutures.add(new Schedule<>(5, job2));
        scheduledFutures.add(new Schedule<>(3, job3));

        ScheduledFuture<Work> scheduledFuture = WildCardGeneric.max(scheduledFutures);
        scheduledFuture.work();
    }
}