//Priority Round Robin

//PRR: This is a variant of the standard Round Robin (RR) algorithm.
// Processes are divided into two priority classes Higher Priority Class (HPC): processes with priority 0, 1 or 2 and
// Lower Priority Class (LPC): processes with priority 3, 4 or 5.
// PRR algorithm is exactly same as the standard RR algorithm except each HPC process receives a time quantum of 4 units
// and each LPC process receives a time quantum of 2 units.

public class PRR extends SchedulingAlgo {
    private final int HIGHTIMEQUANT = 4;
    private final int LOWTIMEQUANT = 2;

    PRR(int givenDispTime) {
        super("PRR", givenDispTime);
    }

    @Override
    Result run() {
        log("Initialising " + this.getName() + " Algorithm...");
        Job runningJob;
        Job prevRunningJob = null;
        int timeRunning = 0;
        int currentTimeQuant;
        boolean wack = false;

        while (this.finishedJobs.size() < this.allJobs.size()) { // Main loop
            if (!wack) {
                this.addArrived();
            }
            wack = false;

            this.checkFinished();
//            Dont need to sort?

            if (this.currentJobs.size() > 0) {
                runningJob = this.currentJobs.get(0); // Get job at top of list

                if (!runningJob.equalTo(prevRunningJob)) { // run dispatcher if new job
                    this.eventList.add(new Event("Dispatcher", this.getCurrentTime()));
                    this.incCurrentTime(getDispTime());
                    this.eventList.add(new Event(runningJob.getId(), runningJob.getPriority(), this.getCurrentTime()));
                    this.addArrived(); // check arrived again because only adds if arrived on exact time
                }

                if (runningJob.getPriority() <= 2) {
                    currentTimeQuant = HIGHTIMEQUANT;
                } else {
                    currentTimeQuant = LOWTIMEQUANT;
                }
                this.incCurrentTime(1);
                runningJob.executeForTime(1);
                timeRunning++;
                prevRunningJob = runningJob;

                if (timeRunning == currentTimeQuant) {
                    this.addArrived();
                    wack = true;
                    this.moveToEndOfCurrentJobs(); // dont like this
                    timeRunning = 0;
                    this.checkFinished();
                }
                if (runningJob.getRemainingExecTime() == 0) { // should fix some problems, nvm does not
                    timeRunning = 0;
                    this.checkFinished();
                }
            }
            else {
//                TODO: FIX - MAY EXIT WHEN GAP IN JOBS?
            }
        }
        this.calcStats();
        log("Finished");
        return new Result(this.getName(), this.getDispTime(), this.eventList, this.finishedJobs);
    }

    @Override
    void log(String message) {
        System.out.println(PRR.class.getName() + ": " + message);
    }

}
