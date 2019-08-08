package item_29;

public class Main {
    public static void main(String[] args) {
        StackGeneric<Integer> stackGeneric = new StackGeneric<>();
        for (int i = 0; i < 5; i++) {
            stackGeneric.push(i);
        }
        while (!stackGeneric.isEmpty()) {
            System.out.println(stackGeneric.pop());
        }
    }
}
