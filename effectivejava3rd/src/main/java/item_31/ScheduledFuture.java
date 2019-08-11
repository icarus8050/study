package item_31;

public interface ScheduledFuture<V> extends Delayed {
    void work();
}
