public class Job {

    private String id;
    private int arriveTime;
    private int execSize;
    private int priority;

    public Job() {
        this.id = "";
        this.arriveTime = 0;
        this.execSize = 0;
        this.priority = 0;
    }

    public Job(String givenID, int givenArriveTime, int givenExecSize, int givenPriority) {
        this();
        this.id = givenID;
        this.arriveTime = givenArriveTime;
        this.execSize = givenExecSize;
        this.priority = givenPriority;
    }


}
