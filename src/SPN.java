

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
                this.incCurrentTime(this.getDispTime());
            }

            if (this.currentJobs.size() > 0) {
                Job temp = this.currentJobs.get(0); // Get job at top of list
                int timetemp = getCurrentTime();
                this.incCurrentTime(1);
                temp.executeForTime(getCurrentTime() - timetemp);

                if (temp.getRemainingExecTime() == 0) {
                    jobFinished = true;
                    temp.calculateStats();
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
        return new Result(eventList);
    }

    @Override
    void log(String message) {
        System.out.println(SPN.class.getName() + ": " + message);
    }

}
