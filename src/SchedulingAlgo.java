import java.util.*;

public abstract class SchedulingAlgo {

    private String name;
    protected ArrayList<Job> allJobs;
    protected ArrayList<Job> currentJobs;
    protected ArrayList<Job> finishedJobs;
    protected ArrayList<Event> eventList;

    private int dispTime;
    private int currentTime;

    SchedulingAlgo(String givenName, int givenDispTime) {
        allJobs = new ArrayList<Job>();
        currentJobs = new ArrayList<Job>();
        finishedJobs = new ArrayList<Job>();
        eventList = new ArrayList<Event>();

        name = givenName;
        dispTime = givenDispTime;
        currentTime = 0;
    }

    protected void setDispTime(int t) {
        dispTime = t;
    }

    protected int getDispTime() {
        return dispTime;
    }

    protected int getCurrentTime() {
        return currentTime;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }


    abstract Result run(); // must be implemented in algo classes
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
        for (Job temp : currentJobs) {
            if (temp.getRemainingExecTime() == 0) {
                temp.setFinishTime(getCurrentTime());
                finishedJobs.add(temp);
            }
        }
        currentJobs.removeIf(temp -> temp.getRemainingExecTime() == 0);
    }

    protected void moveToEndOfCurrentJobs() { // moves job currently at top to the bottom
        if (currentJobs.size() > 0) { // avoid errors if list is empty
            Job temp = this.currentJobs.get(0);
            currentJobs.remove(0);
            currentJobs.add(temp); // automatically adds to bottom of list
        }
    }

//    Calculate stats on all jobs
    protected void calcStats() {
        for (Job temp : finishedJobs) {
            temp.calculateStats();
        }
    }

    public void addJob(Job job) { // accepts a single job
        allJobs.add(job);
    }

    public void addJobs(ArrayList<Job> j) { // accepts a whole ArrayList of jobs, overwrites all current
//        Have to do deep copy?
        for (Job temp : j) {
            allJobs.add(new Job(temp.getId(), temp.getArriveTime(), temp.getExecTime(), temp.getPriority()));
        }
    }

}