

// Shortest process next
public class SPN extends SchedulingAlgo {



    SPN(int givenDispTime ) {
        super("SPN", givenDispTime);
    }

    @Override
    void run() {
        log("Initialising " + this.getName() + "Algorithm...");

//        Currently pre-emptive????
        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();
            this.currentJobs.sort(Job.execTimeComparitor());

            if (this.currentJobs.size() > 0) {
//                Get the job at the top of the list
                Job temp = this.currentJobs.get(0);
                int timetemp = getCurrentTime();

                this.incCurrentTime(1);

                temp.executeForTime(getCurrentTime() - timetemp);
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
