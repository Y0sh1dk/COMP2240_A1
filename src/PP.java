// Standard preemptive priority scheduling algorithm
// 0 is highest priority, 5 lowest

public class PP extends SchedulingAlgo {
    PP(int givenDispTime ) {
        super("PP", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + " Algorithm...");

        boolean jobFinished = true;
        boolean runDispatcher = true;
        Job runningJob;
        Job prevRunningJob = null;

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();
            this.currentJobs.sort(Job.priorityComparitor());

            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // Get job at top of list

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.incCurrentTime(getDispTime());
                }

                int timetemp = getCurrentTime();
                this.incCurrentTime(1);
                runningJob.executeForTime(getCurrentTime() - timetemp);

                prevRunningJob = runningJob;

                if (runningJob.getRemainingExecTime() == 0) {
                    jobFinished = true;
                    runningJob.calculateStats();
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
        System.out.println(PP.class.getName() + ": " + message);
    }


}
