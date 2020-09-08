import java.util.*;

public abstract class SchedulingAlgo {

    private String name;
    protected ArrayList<Job> allJobs;
    protected ArrayList<Job> currentJobs;
    protected ArrayList<Job> finishedJobs;

    private int dispTime;
    private int currentTime;

    SchedulingAlgo(String givenName, int givenDispTime) {
        this.allJobs = new ArrayList<Job>();
        this.currentJobs = new ArrayList<Job>();
        this.finishedJobs = new ArrayList<Job>();

        this.name = givenName;
        this.dispTime = givenDispTime;
        this.currentTime = 0;
    }

    protected void setDispTime(int t) {
        this.dispTime = t;
    }

    protected int getDispTime() {
        return this.dispTime;
    }

    protected int getCurrentTime() {
        return this.currentTime;
    }


    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    abstract void run(); // must be implemented in algo classes
    abstract void log(String message); // must be implemented in algo classes

    //    If a new job has arrived, add it to currentJobs
    protected void addArrived() {
        for (Job temp : allJobs) {
            if (temp.getArriveTime() == getCurrentTime()) {
                currentJobs.add(temp);
            }
        }
    }

    //    Increment current time by set amount
    protected void incCurrentTime(int t) {
        this.currentTime += t;
    }

//    Move jobs that have finished executing from currentJobs to finished Jobs
    protected void checkFinished() {
        //                finishedJobs.add(temp);
        for (Job temp : currentJobs) {
            if (temp.getRemainingExecTime() == 0) {
                temp.setFinishTime(this.getCurrentTime());
                finishedJobs.add(temp);
            }
        }
        currentJobs.removeIf(temp -> temp.getRemainingExecTime() == 0);
    }


    public void addJob(Job job) { // accepts a single job
        allJobs.add(job);
    }

    public void addJobs(ArrayList<Job> j) { // accepts a whole ArrayList of jobs, overwrites all current
        this.allJobs = j;
    }

}