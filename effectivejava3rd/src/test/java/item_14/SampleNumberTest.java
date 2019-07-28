package item_14;

import org.junit.Test;

import java.util.*;

public class SampleNumberTest {

    @Test
    public void 핵심필드가_여러개일때() {
        List<SampleNumber> sampleNumbers = Arrays.asList(
                new SampleNumber(11, 22, 33),
                new SampleNumber(11, 21, 33),
                new SampleNumber(10, 25, 34),
                new SampleNumber(15, 1, 4)
        );
        sampleNumbers.stream()
                .forEach(num -> System.out.println(num.toString()));

        System.out.println("-------------------");
        Collections.sort(sampleNumbers);

        sampleNumbers.stream()
                .forEach(num -> System.out.println(num.toString()));
    }

    @Test
    public void priorityQueueTest() {
        PriorityQueue<SampleNumber> priorityQueue =
                new PriorityQueue<>((num_1, num_2) -> num_2.compareTo(num_1));
        priorityQueue.add(new SampleNumber(4, 2, 4));
        priorityQueue.add(new SampleNumber(4, 1, 4));
        priorityQueue.add(new SampleNumber(1, 40, 40));
        priorityQueue.add(new SampleNumber(1, 29, 29));

        for (Iterator<SampleNumber> iterator = priorityQueue.iterator(); iterator.hasNext(); ) {
            SampleNumber next = iterator.next();
            System.out.println(next.toString());
        }
    }
}