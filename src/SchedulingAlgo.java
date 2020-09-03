import java.util.*;

public abstract class SchedulingAlgo {
    private String name;
    private Queue<Job> algoJobQueue;
    private List<Job> algoFinishedJobs; // just list is ok?
    private ArrayList<Job> jobs;

    SchedulingAlgo(String givenName) {
        this.name = givenName;
    }

    public void addJob(Job job) { // accepts a single job
        jobs.add(job);
    }

    public void addJobs(ArrayList<Job> j) { // accepts a whole list of jobs
        this.jobs = j;
    }





}
