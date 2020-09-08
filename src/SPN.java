

// Shortest process next
public class SPN extends SchedulingAlgo {



    SPN(int givenDispTime ) {
        super("SPN", givenDispTime);
    }

    @Override
    void run() {
        log("Initialising " + this.getName() + " Algorithm...");
        
        boolean jobFinished = true;
        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();
            if (jobFinished == true) { // this should make it non-pre-emptive
                this.currentJobs.sort(Job.execTimeComparitor());
            }


            if (this.currentJobs.size() > 0) {
                Job temp = this.currentJobs.get(0); // Get job at top of list
                int timetemp = getCurrentTime();
                this.incCurrentTime(1);
                temp.executeForTime(getCurrentTime() - timetemp);

                if (temp.getRemainingExecTime() == 0) {
                    jobFinished = true;
                } else {
                    jobFinished = false;
                }
            }
            else {
//                TODO: FIX - MAY EXIT WHEN GAP IN JOBS?
            }


        }
//        read in new jobs
//        do stuff
//        record event?
//        increment
        log("finished");
    }

    @Override
    void log(String message) {
        System.out.println(SPN.class.getName() + ": " + message);
    }

// Sort all current jobs in order of shortest execution time
    void sortCurrentJobs() {
        for (Job temp : currentJobs) {

        }
    }
}
