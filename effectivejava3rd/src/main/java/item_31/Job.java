package item_31;

public class Job implements Work {

    private String jobName;

    public Job(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void running() {
        System.out.println("working..." + jobName);
    }
}
