

// Shortest process next
public class SPN extends  SchedulingAlgo {



    SPN(int givenDispTime ) {
        super("SPN", givenDispTime);
    }

    @Override
    void run() {
        log("Initialising " + this.getName() + "Algorithm...");

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();

            this.incCurrentTime(1);

        }
//        read in new jobs
//        do stuff
//        record event?
//        increment
    }

    @Override
    void log(String message) {
        System.out.println(SPN.class.getName() + ": " + message);
    }


}
