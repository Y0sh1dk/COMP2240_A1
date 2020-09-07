public class Job {

    private String id;
    private int arriveTime;
    private int execTime;
    private int remainingExecTime;
    private int priority;
    private int finishTime;

    public Job() {
        this.id = "";
        this.arriveTime = 0;
        this.execTime = 0;
        this.priority = 0;
    }

    public Job(String givenID, int givenArriveTime, int givenExecTime, int givenPriority) {
        this();
        this.id = givenID;
        this.arriveTime = givenArriveTime;
        this.execTime = givenExecTime;
        this.remainingExecTime = this.execTime;
        this.priority = givenPriority;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public int getExecTime() {
        return execTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public int getRemainingExecTime() {
        return remainingExecTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public void setExecTime(int execSize) {
        this.execTime = execSize;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setRemainingExecTime(int remainingExecTime) {
        this.remainingExecTime = remainingExecTime;
    }

    public void executeForTime(int t) {
        this.remainingExecTime -= t;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public boolean isValid() { // is valid if it has a name and a execSize
        return !this.id.equals("") && this.execTime != 0; // return true if
    }
}
