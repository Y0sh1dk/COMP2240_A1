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

    public int getArriveTime() {
        return arriveTime;
    }

    public int getExecSize() {
        return execSize;
    }

    public int getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public void setExecSize(int execSize) {
        this.execSize = execSize;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isValid() { // is valid if it has a name and a execSize
        return !this.id.equals("") && this.execSize != 0; // return true if
    }
}
