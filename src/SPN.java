

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
            this.checkFinished();
            if (jobFinished) { // this should make it non-pre-emptive
                this.currentJobs.sort(Job.execTimeComparitor());
                this.eventList.add(new Event("Dispatcher", this.getCurrentTime()));
                this.incCurrentTime(getDispTime());
                this.addArrived();
            }

            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // Get job at top of list

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                }

                int timetemp = getCurrentTime();
                this.incCurrentTime(1);
                runningJob.executeForTime(getCurrentTime() - timetemp);

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
        log("finished");
        return new Result(this.getName(), this.getDispTime(), this.eventList, this.finishedJobs);
    }

    @Override
    void log(String message) {
        System.out.println(SPN.class.getName() + ": " + message);
    }

}
