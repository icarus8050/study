package item_14;

public class Node implements Comparable<Node> {

    private String content;
    private int order;

    public Node(String content, int order) {
        this.content = content;
        this.order = order;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(order, o.order);
    }

    @Override
    public String toString() {
        return "content : " + content + ", order : " + order;
    }
}
