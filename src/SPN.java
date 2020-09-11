

// Shortest process next
public class SPN extends SchedulingAlgo {



    SPN(int givenDispTime ) {
        super("SPN", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + " Algorithm...");
        boolean jobFinished = true;
        Job runningJob;
        Job prevRunningJob = null;
        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished(); // remove finished jobs
            if (jobFinished) { // this should make it non-pre-emptive
                this.currentJobs.sort(Job.execTimeComparitor()); // sort
                this.eventList.add(new Event("Dispatcher", this.getCurrentTime())); // Add dispatcher event
                this.incCurrentTime(getDispTime());
                this.addArrived();
            }
            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // Get job at top of list

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                }
                this.incCurrentTime(1);
                runningJob.executeForTime(1);
                prevRunningJob = runningJob;
                if (runningJob.getRemainingExecTime() == 0) {
                    jobFinished = true;
                } else {
                    jobFinished = false;
                }
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
        System.out.println(SPN.class.getName() + ": " + message);
    }

}
