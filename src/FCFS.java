// First Come First Serve

import java.util.Collections;

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
            this.currentJobs.sort(Job.arriveTimeComparitor());

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
        log("finished");
    }

    @Override
    void log(String message) {
        System.out.println(FCFS.class.getName() + ": " + message);
    }
}
