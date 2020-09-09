//Priority Round Robin

//PRR: This is a variant of the standard Round Robin (RR) algorithm.
// Processes are divided into two priority classes Higher Priority Class (HPC): processes with priority 0, 1 or 2 and
// Lower Priority Class (LPC): processes with priority 3, 4 or 5.
// PRR algorithm is exactly same as the standard RR algorithm except each HPC process receives a time quantum of 4 units
// and each LPC process receives a time quantum of 2 units.
// TODO: THIS ALGO HASNT BEEN DONE!!!

public class PRR extends SchedulingAlgo {
    private int timeQuantum;

    PRR(int givenDispTime) {
        super("PRR", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + " Algorithm...");

        boolean jobFinished = true;
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
        System.out.println(PRR.class.getName() + ": " + message);
    }

}
