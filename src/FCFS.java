// First Come First Serve

import java.util.Collections;

public class FCFS extends SchedulingAlgo {

    FCFS(int givenDispTime ) {
        super("FCFS", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + "Algorithm...");

        boolean jobFinished = true;
        Job runningJob;
        Job prevRunningJob = null;

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            this.addArrived();
            this.checkFinished();
            this.currentJobs.sort(Job.arriveTimeComparitor());

            if (jobFinished) { // run dispatcher
                this.eventList.add(new Event("Dispatcher", this.getCurrentTime()));
                this.incCurrentTime(this.getDispTime());
            }

            if (this.currentJobs.size() > 0) {
//                Get the job at the top of the list
                runningJob = this.currentJobs.get(0);

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event("Dispatcher", this.getCurrentTime()));
                    this.incCurrentTime(getDispTime());
                    this.eventList.add(new Event(runningJob.getId(), this.getCurrentTime()));
                }

                int timetemp = getCurrentTime();
                this.incCurrentTime(1); // time step of 1
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
        return new Result(eventList);
    }

    @Override
    void log(String message) {
        System.out.println(FCFS.class.getName() + ": " + message);
    }
}
