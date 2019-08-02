package item_17.protected_pack;

public class Parent {

    public void print() {
        System.out.println("I'm Parent");
    }

    public void greeting() {
        System.out.println("HelloWorld!");
    }

    protected void run() {
        System.out.println("running...");
    }

    private void hidden() {
        System.out.println("hidden method");
    }

    protected void delegating() {
        hidden();
    }
}
