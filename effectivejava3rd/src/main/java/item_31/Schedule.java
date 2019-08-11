package item_31;

public class Schedule<V extends Work> implements ScheduledFuture<V> {

    private int priority;
    private V job;

    public Schedule(int priority, V job) {
        this.priority = priority;
        this.job = job;
    }

    @Override
    public void work() {
        job.running();
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(Delayed o) {
        return this.getPriority() - o.getPriority();
    }
}
