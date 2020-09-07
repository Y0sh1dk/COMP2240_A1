// First Come First Serve

public class FCFS extends SchedulingAlgo {

    FCFS(int givenDispTime ) {
        super("FCFS", givenDispTime);
    }

    @Override
    void run() {
        log("Initialising " + this.getName() + "Algorithm...");

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();

            if (this.currentJobs.size() > 0) {
                Job temp = this.currentJobs.get(0);
                int timetemp = getCurrentTime();

                this.incCurrentTime(1);

                temp.executeForTime(getCurrentTime() - timetemp);
            }
            else {
//                TODO: FIX - MAY EXIT WHEN GAP IN JOBS?
                continue;
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
        System.out.println(FCFS.class.getName() + ": " + message);
    }

    private void currentJobs() {

    }


}
