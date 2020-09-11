// First Come First Serve
public class FCFS extends SchedulingAlgo {
    FCFS(int givenDispTime ) {
        super("FCFS", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + "Algorithm...");
        Job runningJob;
        Job prevRunningJob = null;

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished(); // remove finished jobs
            this.currentJobs.sort(Job.arriveTimeComparitor()); // sort
            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // get job at top of list
                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event("Dispatcher", this.getCurrentTime())); // add disp event
                    this.incCurrentTime(getDispTime());
                    // add job event
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                    this.addArrived(); // check arrived again because only adds if arrived on exact time
                }
                this.incCurrentTime(1); // time step of 1
                runningJob.executeForTime(1);
                prevRunningJob = runningJob; // assign current job to prev var for to compare later
            }
        }
        this.calcStats(); // Calculate waiting time and turnaround time
        log("Finished running algo...\n");
        return new Result(this.getName(), this.getDispTime(), this.eventList, this.finishedJobs);
    }

    @Override
    void log(String message) {
        System.out.println(FCFS.class.getName() + ": " + message);
    }

}
