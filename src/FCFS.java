// First Come First Serve

import java.util.Collections;

public class FCFS extends SchedulingAlgo {

    FCFS(int givenDispTime ) {
        super("FCFS", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + "Algorithm...");
        Job runningJob;
        Job prevRunningJob = null;

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();
            this.currentJobs.sort(Job.arriveTimeComparitor());

            if (this.currentJobs.size() > 0) {
//                Get the job at the top of the list
                runningJob = this.currentJobs.get(0);

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event("Dispatcher", this.getCurrentTime()));
                    this.incCurrentTime(getDispTime());
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                    this.addArrived(); // check arrived again because only adds if arrived on exact time
                }

                int timetemp = getCurrentTime();
                this.incCurrentTime(1); // time step of 1
                runningJob.executeForTime(getCurrentTime() - timetemp);

                prevRunningJob = runningJob;
            }
        }
        this.calcStats();
        log("Finished running algo...\n");
        return new Result(this.getName(), this.getDispTime(), this.eventList, this.finishedJobs);
    }

    @Override
    void log(String message) {
        System.out.println(FCFS.class.getName() + ": " + message);
    }
}
