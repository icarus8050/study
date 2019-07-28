package item_14;

import java.util.Comparator;

public class SampleNumber implements Comparable<SampleNumber> {
    private int first;
    private int second;
    private int third;

    public SampleNumber(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(SampleNumber o) {
        return COMPARATOR.compare(this, o);
    }

    private static final Comparator<SampleNumber> COMPARATOR =
            Comparator.comparingInt((SampleNumber num) -> num.first)
                    .thenComparingInt(num -> num.second)
                    .thenComparingInt(num -> num.third);

    @Override
    public String toString() {
        return "[first : " + first + "]" + "[second : " + second + "]" + "[third : " + third + "]";
    }
}
