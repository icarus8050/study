package item_14;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class CaseInsensitiveStringTest {

    @Test
    public void simpleCompareTest() {
        Set<CaseInsensitiveString> treeSet = new TreeSet<>();
        treeSet.addAll(
                Arrays.asList(
                        new CaseInsensitiveString("d"),
                        new CaseInsensitiveString("c"),
                        new CaseInsensitiveString("b"),
                        new CaseInsensitiveString("a")
                )
        );

        treeSet.stream().forEach(caseInsensitiveString -> System.out.println(caseInsensitiveString.toString()));
    }

}