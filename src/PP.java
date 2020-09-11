// Standard preemptive priority scheduling algorithm
// 0 is highest priority, 5 lowest

public class PP extends SchedulingAlgo {
    PP(int givenDispTime ) {
        super("PP", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + " Algorithm...");
        Job runningJob;
        Job prevRunningJob = null;
        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished(); // remove finished jobs
            this.currentJobs.sort(Job.priorityComparitor()); // sort
            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // Get job at top of list
                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event("Dispatcher", this.getCurrentTime())); // add disp event
                    this.incCurrentTime(getDispTime());
                    // add job event
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                    this.addArrived(); // check arrived again because only adds if arrived on exact time
                }
                this.incCurrentTime(1);
                runningJob.executeForTime(1);
                prevRunningJob = runningJob;
            }
            else {
//                TODO: FIX - MAY EXIT WHEN GAP IN JOBS?
            }
        }
        this.calcStats();
        log("Finished running algo...\n");
        return new Result(this.getName(), this.getDispTime(), this.eventList, this.finishedJobs);
    }

    @Override
    void log(String message) {
        System.out.println(PP.class.getName() + ": " + message);
    }

}
