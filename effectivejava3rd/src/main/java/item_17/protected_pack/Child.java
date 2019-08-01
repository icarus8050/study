package item_17.protected_pack;

public class Child extends Parent {

    @Override
    public void print() {
        System.out.println("I'm Child");
    }

    @Override
    protected void run() {
        System.out.println("child run...");
    }
}
