import java.util.Comparator;

public class Job {

    private String id;
    private int arriveTime;
    private int execTime;
    private int remainingExecTime;
    private int priority;
    private int finishTime;
    private int waitingTime; // turnaroundTime - execTime;
    private int turnaroundTime; // Arrive time - finishTime

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
        return this.priority;
    }

    public String getId() {
        return id;
    }

    public int getRemainingExecTime() {
        return remainingExecTime;
    }

    public int getWaitingTime() {
        return this.waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public int getFinishTime() {
        return finishTime;
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

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void executeForTime(int t) {
        this.remainingExecTime -= t;
    }

    public void calculateStats() {
        this.turnaroundTime = this.finishTime - this.arriveTime;
        this.waitingTime = this.turnaroundTime - this.execTime;
    }


    public boolean isValid() { // is valid if it has a name and a execSize
        return !this.id.equals("") && this.execTime != 0; // return true if
    }



//    Comparators used for sorting
    static Comparator<Job> priorityComparitor() { // Highest priority (lowest number) first
        return new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getPriority() < j2.getPriority()) {
                    return -1;
                } else if (j1.getPriority() == j2.getPriority()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
    }

    static Comparator<Job> execTimeComparitor() { // Longest time first
        return new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getExecTime() < j2.getExecTime()) {
                    return -1;
                } else if (j1.getExecTime() == j2.getExecTime()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
    }

    static Comparator<Job> remainingTimeComparitor() { // Longest time first
        return new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getRemainingExecTime() < j2.getRemainingExecTime()) {
                    return 1;
                } else if (j1.getRemainingExecTime() == j2.getRemainingExecTime()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
    }

    static Comparator<Job> arriveTimeComparitor() { // Longest time first
        return new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                if (j1.getArriveTime() < j2.getArriveTime()) {
                    return -1;
                } else if (j1.getArriveTime() == j2.getArriveTime()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
    }

    public boolean equalTo(Job j) {
        if (j == null) {
            return false;
        } else if (this.id.equals(j.id) && this.arriveTime == j.arriveTime
                && this.execTime == j.execTime && this.priority == j.priority) { // Then the jobs are the same
            return true; // return 1 if same
        } else {
            return false; // return 0 if not same
        }
    }


}
