package item_14;

import org.junit.Test;

import java.util.Arrays;

public class NodeTest {

    @Test
    public void simpleOrderingNode() {
        Node[] nodes = new Node[3];
        nodes[0] = new Node("five", 5);
        nodes[1] = new Node("three", 3);
        nodes[2] = new Node("one", 1);

        Arrays.sort(nodes);
        Arrays.stream(nodes)
                .forEach(n -> System.out.println(n.toString()));
    }
}